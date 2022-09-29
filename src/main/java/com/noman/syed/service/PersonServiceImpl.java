package com.noman.syed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.noman.syed.dao.PersonDao;
import com.noman.syed.model.Person;

public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao personDAO;

	public void setPersonDAO(PersonDao personDAO) {
		this.personDAO = personDAO;
	}
	
	@Override
	public void addPerson(Person p) {
		personDAO.addPerson(p);
		
	}

	@Override
	public void updatePerson(Person p) {
		personDAO.updatePerson(p);
		
	}

	@Override
	public List<Person> listPersons() {
		return personDAO.listPersons();
	}

	@Override
	public Person getPersonById(int id) {
		return personDAO.getPersonById(id);
	}

	@Override
	public void removePerson(int id) {
		personDAO.removePerson(id);
		
	}
}
