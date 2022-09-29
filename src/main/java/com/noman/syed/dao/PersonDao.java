package com.noman.syed.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.noman.syed.model.Person;

@Repository
public interface PersonDao {
	
	public void addPerson(Person p);
	
	public void updatePerson(Person p);
	
	public List<Person> listPersons();
	
	public Person getPersonById(int id);
	
	public void removePerson(int id);

}
