package com.jpa.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.JpaSpringHibernateApplication;
import com.jpa.entity.Course;
import com.jpa.entity.Review;

import net.sf.ehcache.CacheManager;

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

	@Test
	public void findAll_Query() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
		List<Course> courses = query.getResultList();
		logger.info("Courses Retrieved {} : ", courses);
//		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	public void findAll_NamedQuery() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> courses = query.getResultList();
		logger.info("Courses Retrieved {} : ", courses);
//		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	public void findByWhere_NamedQuery() {
		TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);
		List<Course> coursesLike100Steps = query.getResultList();
		logger.info("Courses like 100 steps Retrieved {} : ", coursesLike100Steps);
//		assertEquals("JPA in 50 Steps", course.getName());
	}

	/**
	 * @@DirtiesContext ensures that data deleted is inserted back into the DB, bcoz
	 *                  from test cases it is not a good habit to delete data..
	 *                  Spring automatically resets the data after the test is run
	 */
	@Test
	@DirtiesContext
	public void deleteById_basic() {
//		repository.deleteById(10002L);
//		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		// get a course
		Course course = repository.findById(10001L);
		
//		assertEquals("JPA in 50 Steps", course.getName());

		// update details // test the update scenario
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(10001L);
//		assertEquals("JPA in 50 Steps - Updated", course1.getName());

		Course course2 = new Course("JPA in 666 min");
		repository.save(course2);
	
		logger.info("Courses Retrieved {} : ", course2.getId());

	}
	
	@Test
	@Transactional
	public void testCache() {
		int sizeBeforeCache = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.jpa.entity.Course").getSize();
		Course course = repository.findById(10001L);
		int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
				  .getCache("com.jpa.entity.Course").getSize();
		logger.info("Size of cache : {}" + size);
		
		Course course2 = repository.findById(10001L);
		course2.getReviews();
		course2.getReviews();
		course2.getReviews();
		course2.getStudents();
		repository.findById(10001L);
		repository.findById(10001L);
		repository.findById(10001L);
		repository.findById(10002L);
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void addHardCodedReviews() {
		List<Review> reviews = new ArrayList<>();

		reviews.add(new Review("3", "Pretty good."));
		reviews.add(new Review("5", "Outstanding."));
		repository.addHardCodedReviewsForCourse(10003L, reviews);
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(10003L);
		logger.info("{}", course.getReviews());
		Course course2 = repository.findById(10001L);
		logger.info("{}", course2.getReviews());
	}

	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("{}", review.getCourse());
	}

}
