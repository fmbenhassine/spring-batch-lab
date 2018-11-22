package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * For simplicity, there is a single word per line in the input file.
 * The sample can be adapted to split each line into a set of words and calculate
 * the frequency of each word.
 */

@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication {

	/*
	 * Run with the following arguments: workingDirectory=src/main/resources/ inputFile=names.txt prefix=partition_ partitionSize=4
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
