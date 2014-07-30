package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Person;

@Stateless
public class PersonDaoBean implements PersonDaoRemote {

	public static final String SELECT_PERSON_SQL = "select p from Person p where p.id = :id";
	
	@PersistenceContext(name = "LucpPerson")
	private EntityManager entityManager;
	
	@Override
	public void savePerson(Person person) {
		this.entityManager.persist(person);
	}

	@Override
	public Person loadPerson(Long personId) {
		Query q = this.entityManager.createQuery(PersonDaoBean.SELECT_PERSON_SQL);
		q.setParameter("id", personId);
		Person person = (Person) q.getSingleResult();
		return person;
	}

	@Override
	public Person loadPerson(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
