package com.noman.syed.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.noman.syed.dao.NewPersonDaoImpl;
import com.noman.syed.dao.PersonDao;
import com.noman.syed.dao.PersonDaoImpl;
import com.noman.syed.service.PersonService;
import com.noman.syed.service.PersonServiceImpl;

@Configuration
@ComponentScan("com.noman.syed.controller")
@EnableWebMvc
@EnableTransactionManagement
@ImportResource("classpath:/spring-configuration.xml")
public class PartialWebConfig {
	
	@Bean
	@Qualifier("personservice")
	public PersonService publicService(){
		PersonService ps = new PersonServiceImpl();
		return ps ;
	}
	
	@Bean
	public PersonDao personDao(){
		PersonDao dao = new PersonDaoImpl();
		return dao;
		
	}
	
	@Bean
	public InternalResourceViewResolver setupViewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);

		return resolver;
	}

	@Bean
	public ResourceBundleMessageSource setMessageResource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		resource.setDefaultEncoding("UTF-8");
		return resource;

	}


}
