package client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Person;
import dao.PersonDaoBean;
import dao.PersonDaoRemote;
import service.CounterBeanRemote;

public class PersonClient {

	public static void main(String[] args) {
		try {
			
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(jndiProperties);
			PersonDaoRemote personDao = (PersonDaoRemote) context.lookup("ejb:ejb-package-1.0.0-SNAPSHOT/ejb-dao-1.0.0-SNAPSHOT/PersonDaoBean!dao.PersonDaoRemote");
			Person person = new Person("Jon Smith","London",10000);
			personDao.savePerson(person);
			System.out.println(personDao.loadPerson(2L).getName());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
		
		}
	}

}
