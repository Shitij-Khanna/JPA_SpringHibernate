package com.jpa.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.JpaSpringHibernateApplication;
import com.jpa.entity.Passport;
import com.jpa.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaSpringHibernateApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EntityManager em;
	
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student ->S {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
//	@Test
//	@Transactional
//	public void setAddressDetails() {
//		Student student = em.find(Student.class, 20001L);
//		student.setAddress(new Address("No 101", "Some Street", "Hyderabad"));
//		em.flush();
//	}
//
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40004L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}

}
