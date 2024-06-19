package com.crypto_rates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
//		Transaction transaction = session.beginTransaction();

//		User user = new User("abhiram","user@gmail.com","Abhiram","Deshpande","Password@123","9146404087");

//try{
//
//	session.save(user);
//}
//catch (ConstraintViolationException e){
//
//}
//			transaction.commit();
//			session.close();



	}

}
