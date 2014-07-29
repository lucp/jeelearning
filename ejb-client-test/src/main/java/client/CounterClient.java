package client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.CounterBeanRemote;

public class CounterClient {

	public static void main(String[] args) {		
		try {
			
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(jndiProperties);
			CounterBeanRemote counter = (CounterBeanRemote) context.lookup("ejb:ejb-package-1.0.0-SNAPSHOT/ejb-service/CounterBean!service.CounterBeanRemote");
			
			System.out.println("Counter state: "+ counter.increment());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
