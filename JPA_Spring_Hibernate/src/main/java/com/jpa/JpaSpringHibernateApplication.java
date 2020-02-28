package com.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.entity.Course;
import com.jpa.entity.Review;
import com.jpa.repository.CourseRepository;
import com.jpa.repository.StudentRepository;

@SpringBootApplication
public class JpaSpringHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	EntityManager em;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("Course details -> {}", 
//				courseRepository.findById(10001L).getName());

//		courseRepository.deleteById(10001L);
//		courseRepository.playWithEntityManager();
		
//		studentRepository.saveStudentWithPassport();
		
//	List<Review> reviews = new ArrayList<>();
//
//	reviews.add(new Review("5", "Great Hands-on Stuff."));
//	reviews.add(new Review("5", "Hatsoff."));

//	courseRepository.addReviewsForCourse(10003L, reviews );
	getReviews();
//	Review review = em.find(Review.class, 5L);
//	logger.info("{}", review.getCourse());
	}

	private void getReviews() {
		Course course = courseRepository.findById(10003L);
		logger.info("{}", course.getReviews());
		Course course2 = courseRepository.findById(10001L);
		logger.info("{}", course2.getReviews());
	}

}
