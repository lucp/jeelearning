package web;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Person;
import dao.PersonDaoRemote;

@Path("/PersonRestService")
@Stateless
public class PersonRestService {
	
	@EJB
	private PersonDaoRemote personDao;
	
	@GET
	@Produces("text/html")
	public String introduce() {
		return new String("Hello there, it's Person Rest Service here.");
	}

	public PersonDaoRemote getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDaoRemote personDao) {
		this.personDao = personDao;
	}

	@GET
	@Path("/selectPersons")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> selectPersons() {
		return this.getPersonDao().loadAllPersons();
	}

	@POST
	@Path("/insertPerson")
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertPerson(Person person) {
		System.out.println(person.getName());
		this.getPersonDao().savePerson(person);
	}
}
