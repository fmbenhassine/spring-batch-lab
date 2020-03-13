package com.example.demo;

import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class PerformanceTestApplication {

	public static void main(String[] args) throws Exception {

		// start next instance with job operator
//		ApplicationContext context = SpringApplication.run(PerformanceTestApplication.class, args);
//		JobOperator jobOperator = context.getBean(JobOperator.class);
//		StopWatch stopWatch = new StopWatch();
//		stopWatch.start();
//		Long jobExecutionId = jobOperator.startNextInstance("job");
//		System.out.println("jobExecutionId = " + jobExecutionId);
//		stopWatch.stop();
//		System.out.println(stopWatch.prettyPrint());

		// start next instance with command line job runner
		CommandLineJobRunner.main(new String[]{
						"com.example.demo.MyJob",
						"job",
						"-next"
				}
		);
	}

}
