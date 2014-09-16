package service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "PersonMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/jms/queue/PersonQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class PersonMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage tx = (TextMessage)message;
		try {
			System.out.println(" [PersonMDB] "+tx.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
