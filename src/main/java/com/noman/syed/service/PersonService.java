package com.noman.syed.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noman.syed.model.Person;
@Service
public interface PersonService {

	@Transactional
	public void addPerson(Person p);
	@Transactional
	public void updatePerson(Person p);
	@Transactional
	public List<Person> listPersons();
	@Transactional
	public Person getPersonById(int id);
	@Transactional
	public void removePerson(int id);
}
