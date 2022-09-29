package com.noman.syed.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonService {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
