package com.example.demobatchjms;

import org.apache.activemq.broker.BrokerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class DemoBatchJmsApplication {

	public static void main(String[] args) throws Exception {
		BrokerService brokerService = new BrokerService();
		brokerService.addConnector("tcp://localhost:61616");
		brokerService.start();

		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoBatchJmsApplication.class, args);

		MessageUtils messageUtils = applicationContext.getBean(MessageUtils.class);
		messageUtils.browseMessages();

		brokerService.stop();
	}
}
