package client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.CounterLocal;
import service.CounterBean;

public class CounterClient {

	public static void main(String[] args) {		
		try {
			
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(jndiProperties);
			CounterLocal counter = (CounterLocal) context.lookup("ejb:ejb-package-1.0.0-SNAPSHOT/ejb-test/CounterBean!service.CounterLocal");
			
			System.out.println("Counter state: "+ counter.getNextAndUpdate());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
