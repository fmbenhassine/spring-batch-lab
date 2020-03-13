package org.droidwiki.batchdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.web.client.RestTemplate;

public class Test {
	@org.junit.Test
	public void name() throws InterruptedException {
		final RestTemplate restTemplate = new RestTemplate();
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int i = 1; i <= 50; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					restTemplate.put("http://localhost:8080/api/jobs/" + Thread.currentThread().getId(), null);
				}
			});
		}

		System.out.println("done");
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
	}
}
