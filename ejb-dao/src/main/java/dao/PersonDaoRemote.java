package dao;

import java.util.List;

import javax.ejb.Remote;

import model.Person;

@Remote(PersonDaoRemote.class)
public interface PersonDaoRemote {

	void savePerson(Person person);
	Person loadPerson(Long personId);
	Person loadPerson(String name);
	List<Person> loadAllPersons();
	
}
