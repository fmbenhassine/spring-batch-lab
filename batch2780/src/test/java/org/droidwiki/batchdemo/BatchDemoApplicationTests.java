package org.droidwiki.batchdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BatchDemoApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JobRepository jobRepository;

	private CountDownLatch createJobsAmount = new CountDownLatch(20);

	@Before
	public void setup() throws Exception {
		JobRepositoryTestUtils jobRepositoryTestUtils = new JobRepositoryTestUtils(jobRepository, dataSource);
		jobRepositoryTestUtils.afterPropertiesSet();
		jobRepositoryTestUtils.removeJobExecutions();
	}

	@Test
	public void simulatnouslyCreatingJobs() throws Exception {
		CountDownLatch synchronizeLatch = new CountDownLatch(1);
		List<Thread> threadList = new ArrayList<>();

		System.out.println("Creating " + createJobsAmount.getCount() + " create job requests...");
		for (int i = 0; i <= createJobsAmount.getCount(); i++) {
			Thread thread = new Thread(new CreateJobSynchronized(synchronizeLatch));
			thread.start();
			threadList.add(thread);
		}

		System.out.println("Starting synchronized job creation...");
		synchronizeLatch.countDown();

		for (Thread thread : threadList) {
			System.out.println("Joining thread " + thread.getId() + "...");
			thread.join();
		}

		assertEquals(0, createJobsAmount.getCount());
	}

	public class CreateJobSynchronized implements Runnable {
		private CountDownLatch waitForLatch;

		CreateJobSynchronized(CountDownLatch waitForLatch) {
			this.waitForLatch = waitForLatch;
		}

		@Override
		public void run() {
			try {
				this.waitForLatch.await();

				mockMvc.perform(put("/api/jobs/" + Thread.currentThread().getId()))
						.andExpect(status().isOk())
						.andExpect(content().string(String.valueOf(Thread.currentThread().getId())));

				createJobsAmount.countDown();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
	}
}
