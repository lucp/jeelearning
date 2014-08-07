package web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.Person;

@WebService(targetNamespace = "/PersonWebService")
public interface PersonWebService {

	@WebMethod
	public String introduce();
	
	@WebMethod
	public List<Person> selectPersons();
	
	@WebMethod
	public void insertPerson(@WebParam Person person);
	
}
