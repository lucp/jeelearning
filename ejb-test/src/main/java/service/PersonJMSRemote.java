package service;

import javax.ejb.Remote;

@Remote(CounterBeanRemote.class)
public interface PersonJMSRemote {

	public void sendMessage(String message);
	
}
