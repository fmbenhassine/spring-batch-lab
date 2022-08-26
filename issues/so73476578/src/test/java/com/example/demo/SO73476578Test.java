package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration(classes = {SO73476578.class, DataSourceConfiguration.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class SO73476578Test {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void myTest() {

        /**
         * some mocking and arrangement irrelevant of spring batch
         */


        /**
         * when launching payaReturnedTransactionStep
         */
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("myStep");



        /**
         * some assertions on the number of calls to methods. also irrelevant to spring batch
         */

    }

}