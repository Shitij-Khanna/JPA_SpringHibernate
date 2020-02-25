package com.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.entity.Course;
import com.jpa.repository.CourseRepository;

@SpringBootApplication
public class JpaSpringHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("Course details -> {}", 
//				courseRepository.findById(10001L).getName());

//		courseRepository.deleteById(10001L);
		courseRepository.save(new Course("Microservice course"));

	}

}
