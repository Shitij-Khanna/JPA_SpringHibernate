package com.jpa.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entity.Course;
import com.jpa.entity.Passport;
import com.jpa.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Student save(final Student student) {
		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}
		return student;
	}
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Mike");

		student.setPassport(passport);
//		em.flush();
		logger.info("After flush : " + student.getName());
		student.setName("Mohan");
		em.persist(student);	
	}
	
	public void insertHardcodedStudentAndCourse(){
		Student student = new Student("Jamil");
		Course course = new Course("Elasticsearch Logstash and Kibana");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student);
	}

	public void insertStudentAndCourse(Student student, Course course){
		student.addCourse(course);
		course.addStudent(student);

		em.persist(student);
		em.persist(course);
	}
}
