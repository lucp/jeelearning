package client;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Person;
import dao.PersonDaoRemote;

public class PersonClient {

	public static void main(String[] args) {
		try {
			
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			InitialContext context = new InitialContext(jndiProperties);
			PersonDaoRemote personDao = (PersonDaoRemote) context.lookup("ejb:ejb-package-1.0.0-SNAPSHOT/ejb-dao/PersonDaoBean!dao.PersonDaoRemote");
			Person person = new Person("Adam Clone","New York",100000);
			personDao.savePerson(person);
			List<Person> savedPersons = personDao.loadAllPersons();
			for (Person personInList : savedPersons){
				System.out.println(personInList.toString());
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
		
		}
	}

}
