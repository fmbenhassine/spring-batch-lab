package com.example.demobatchjms;

import java.util.Enumeration;
import javax.annotation.PostConstruct;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

	private JmsTemplate jmsTemplate;

	private ConnectionFactory connectionFactory;

	public MessageUtils(JmsTemplate jmsTemplate, ConnectionFactory connectionFactory) {
		this.jmsTemplate = jmsTemplate;
		this.connectionFactory = connectionFactory;
	}

	@PostConstruct
	public void sendMessages() {

		System.out.println("##########################");
		System.out.println("Sending messages");
		System.out.println("##########################");

		jmsTemplate.send("test-queue", session -> {
			TextMessage textMessage = new ActiveMQTextMessage();
			textMessage.setText("hello");
			return textMessage;
		});
		jmsTemplate.send("test-queue", session -> {
			TextMessage textMessage = new ActiveMQTextMessage();
			textMessage.setText("world");
			return textMessage;
		});
		jmsTemplate.send("test-queue", session -> {
			TextMessage textMessage = new ActiveMQTextMessage();
			textMessage.setText("ok?");
			return textMessage;
		});
	}

	void browseMessages() throws JMSException {

		System.out.println("##########################");
		System.out.println("Browsing messages");
		System.out.println("##########################");

		// Create a Connection
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// Create a Session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("test-queue");

		// Create a browser
		QueueBrowser browser = session.createBrowser(queue);
		Enumeration e = browser.getEnumeration();
		while (e.hasMoreElements()) {
			TextMessage message = (TextMessage) e.nextElement();
			System.out.println("Browse [" + message.getText() + "]");
		}
		System.out.println("Done");
		browser.close();

		// Clean up
		session.close();
		connection.close();
	}

}
