package com.noman.syed.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.noman.syed.model.Person;
public class NewPersonDaoImpl implements PersonDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void addPerson(Person p) {
		System.out.println("Not Implemented yet ..");
		
	}

	@Override
	public void updatePerson(Person p) {
		System.out.println("Not Implemented yet ..");
		
	}

	@Override
	public List<Person> listPersons() {
		System.out.println("Not Implemented yet ..");
		return null;
	}

	@Override
	public Person getPersonById(int id) {
		System.out.println("Not Implemented yet ..");
		return null;
	}

	@Override
	public void removePerson(int id) {
		System.out.println("Not Implemented yet ..");
		
	}

	
	
}
