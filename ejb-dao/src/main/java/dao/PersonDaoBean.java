package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Person;

@Stateless
public class PersonDaoBean implements PersonDaoRemote {

	public static final String SELECT_PERSON_BY_ID_SQL = "select p from Person p where p.id = :id";

	public static final String SELECT_PERSON_BY_NAME_SQL = "select p from Person p where p.name = :name";

	private static final String SELECT_ALL_PERSONS_SQL = "select p from Person p";
	
	@PersistenceContext(name = "LucpPerson")
	private EntityManager entityManager;
	
	@Override
	public void savePerson(Person person) {
		this.entityManager.persist(person);
	}

	@Override
	public Person loadPerson(Long personId) {
		Query query = this.entityManager.createQuery(PersonDaoBean.SELECT_PERSON_BY_ID_SQL);
		query.setParameter("id", personId);
		Person person = (Person) query.getSingleResult();
		return person;
	}

	@Override
	public Person loadPerson(String name) {
		Query query = this.entityManager.createQuery(PersonDaoBean.SELECT_PERSON_BY_NAME_SQL);
		query.setParameter("name", name);
		Person person = (Person) query.getSingleResult();
		return person;
	}

	@Override
	public List<Person> loadAllPersons() {
		Query query = this.entityManager.createQuery(PersonDaoBean.SELECT_ALL_PERSONS_SQL);
		List<Person> person = query.getResultList();
		return person;
	}

}
