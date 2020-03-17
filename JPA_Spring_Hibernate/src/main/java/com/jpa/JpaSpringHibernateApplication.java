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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jpa.entity.Course;
import com.jpa.repository.CourseRepository;
import com.jpa.repository.CourseSpringDataRepository;
import com.jpa.repository.EmployeeRepository;
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

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	CourseSpringDataRepository courseSpringDataRepo;

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
//	getReviews();
//	Review review = em.find(Review.class, 5L);
//	logger.info("{}", review.getCourse());

		// mappings many to many
//		studentRepository.insertHardcodedStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("Laurens"), new Course("Cucumber"));
//		studentRepository.saveStudentWithPassport();

		// Use inheritance strategy
//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//
//		logger.info("Full Time Employees -> {}", 
//				employeeRepository.retrieveAllFullTimeEmployees());
//		
//		logger.info("Part Time Employees -> {}", 
//				employeeRepository.retrieveAllPartTimeEmployees());

		// Use spring data repository to test CRUD operations
		/*
		 * courseSpringDataRepo.findAll(); List<Course> coursesWithNamedQuery =
		 * courseSpringDataRepo.courseWith100StepsInNameUsingNamedQuery();
		 * logger.info("Courses retrieved using named query in jpa repo : {} " +
		 * coursesWithNamedQuery);
		 */

		// Sorting and Paging with spring data JPA
//		List<Course> paginatedCourses = this.getAllCourses(0, 3, "id");
//		logger.info("Paginated courses  : {} " + paginatedCourses);
//		paginatedCourses =  this.getAllCourses(1, 3, "id"); 
//		logger.info("Next set of Paginated courses 1 : {} " + paginatedCourses);
//		paginatedCourses =  this.getAllCourses(2, 3, "id"); 
//	logger.info("Next set of Paginated courses 2 : {} " + paginatedCourses);
		
//		logger.info("All courses 1 : {}" + courseSpringDataRepo.findAll());
//		logger.info("All courses 2 : {}" + courseSpringDataRepo.findAll());
//		logger.info("All courses 3 : {}" + courseSpringDataRepo.findAll());
//		logger.info("All courses 4 : {}" + courseSpringDataRepo.findAll());
		
	}

//	@Transactional
	private void getReviews() {
		Course course = courseRepository.findById(10003L);
		logger.info("{}", course.getReviews());
		
		Course course2 = courseRepository.findById(10001L);
		logger.info("{}", course2.getReviews());
	}

	public List<Course> getAllCourses(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Course> pagedResult = courseSpringDataRepo.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Course>();
		}
	}

}
