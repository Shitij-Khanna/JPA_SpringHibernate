package com.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.entity.Course;
import com.jpa.entity.Review;

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
		Course course = this.findById(id);
		em.remove(course);
	}

	/**
	 * 
	 */
	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);

		Course course2 = this.findById(10001L);

		// Updates the entity in database, because it is still in purview of the EM, txn
		// has not been closed and object is updated, so EM updates the object in DB.
		course2.setName("JPA in 50 Steps - Updated");

	}

	public void addReviewsForCourse(Long courseID, List<Review> reviews) {
		Course course = this.findById(courseID);
		logger.info("course.getReviews() -> {}", course.getReviews());
		for(Review review:reviews)
		{			
			//setting the relationship
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}
	
	public void addHardCodedReviewsForCourse(Long courseID, List<Review> reviews) {
		//get the course 10003
				Course course = findById(10003L);
				logger.info("course.getReviews() -> {}", course.getReviews());
				
				//add 2 reviews to it
				Review review1 = new Review("5", "Great Hands-on Stuff.");	
				Review review2 = new Review("2", "Average.");
				
				//setting the relationship
				course.addReview(review1);
				review1.setCourse(course);
				
				course.addReview(review2);
				review2.setCourse(course);
				
				//save it to the database
				em.persist(review1);
				em.persist(review2);
	}

}
