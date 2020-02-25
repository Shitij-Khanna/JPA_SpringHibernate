package com.jpa.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	public Course findById(Long id) {
		Course course = em.find(Course.class, id);
		logger.info("Course -> {}", course);
		return course;
	}

	/**
	 * @param course
	 * @return The @transactional annotation makes sure that all public methods are
	 *         wrapped in individual transactions If it fails, txn is rolled back
	 */
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);

		Course course2 = findById(10001L);

		course2.setName("JPA in 50 Steps - Updated");

	}

}
