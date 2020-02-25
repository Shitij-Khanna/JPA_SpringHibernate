package com.jpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.JpaSpringHibernateApplication;
import com.jpa.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaSpringHibernateApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager em;

	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	/**
	 * @@DirtiesContext ensures that data deleted is inserted back into the DB, bcoz
	 *                  from test cases it is not a good habit to delete data..
	 *                  Spring automatically resets the data after the test is run
	 */
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		// get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}
	
}
