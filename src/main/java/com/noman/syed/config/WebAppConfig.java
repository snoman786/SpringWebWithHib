package com.noman.syed.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.noman.syed.dao.PersonDao;
import com.noman.syed.dao.PersonDaoImpl;
import com.noman.syed.service.PersonService;
import com.noman.syed.service.PersonServiceImpl;

@Configuration
@ComponentScan("com.noman.syed.controller")
@EnableWebMvc
@EnableTransactionManagement
public class WebAppConfig {

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

	@Bean
	public org.apache.commons.dbcp.BasicDataSource dataSource() {

		org.apache.commons.dbcp.BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mydb");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}

	@Bean
	public AnnotationSessionFactoryBean sessionFactory() {

		org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean sf = 
				new org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean();

		sf.setDataSource(dataSource());
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				"org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", "true");
	//	properties.put("hibernate.current_session_context_class","thread");
		sf.setHibernateProperties(properties);
		sf.setPackagesToScan(new String[] { "com.noman.syed.model" });
		
		return sf;

	}
	
	@Bean
	@Autowired
	public org.springframework.orm.hibernate3.HibernateTransactionManager transactionManager(SessionFactory sf){
		
		org.springframework.orm.hibernate3.HibernateTransactionManager tm = new org.springframework.orm.hibernate3.HibernateTransactionManager();
		tm.setSessionFactory(sf);
		
		return tm ;
	}
	
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
}
