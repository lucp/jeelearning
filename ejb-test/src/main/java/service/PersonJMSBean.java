package service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class PersonJMSBean implements PersonJMSRemote {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName = "java:jboss/jms/queue/PersonQueue")
	private Queue queue;
	
	private Connection connection;

	@Override
	public void sendMessage(String message) {
		try {
			connection = this.connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer publisher = session.createProducer(this.queue);
			connection.start();
			TextMessage textMessage = session.createTextMessage(message);
			publisher.send(textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}	
	
}
