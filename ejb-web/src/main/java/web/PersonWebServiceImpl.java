package web;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import dao.PersonDaoRemote;
import model.Person;

@WebService(serviceName = "PersonWebService", endpointInterface = "web.PersonWebService")
public class PersonWebServiceImpl implements PersonWebService {

	@EJB
	private PersonDaoRemote personDao;
	
	@Override
	public String introduce() {
		return new String("Hello there, it's Person WebService here.");
	}

	public PersonDaoRemote getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDaoRemote personDao) {
		this.personDao = personDao;
	}

	@Override
	public List<Person> selectPersons() {
		return this.getPersonDao().loadAllPersons();
	}

	@Override
	public void insertPerson(Person person) {
		this.getPersonDao().savePerson(person);
	}

}
