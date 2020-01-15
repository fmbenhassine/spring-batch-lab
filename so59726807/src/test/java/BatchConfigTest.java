//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

//import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBatchTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BatchConfig.class)
public class BatchConfigTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @Test
    public void testStep() {
//        assertNotNull(jobLauncherTestUtils, "jobLauncherTestUtils should not be null");
//        assertNotNull(jobRepositoryTestUtils, "jobRepositoryTestUtils should not be null");
        assertNotNull(jobLauncherTestUtils);
        assertNotNull(jobRepositoryTestUtils);
    }

    @Test
    public void testMyJob() throws Exception {
        // given
        JobParameters jobParameters = this.jobLauncherTestUtils.getUniqueJobParameters();

        // when
        JobExecution jobExecution = this.jobLauncherTestUtils.launchJob(jobParameters);

        // then
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }
}
