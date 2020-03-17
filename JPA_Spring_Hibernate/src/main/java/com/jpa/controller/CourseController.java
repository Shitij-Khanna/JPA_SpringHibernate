package com.jpa.controller; 

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Course;
import com.jpa.repository.CourseSpringDataRepository;

@RestController
@RequestMapping("/ITschool/course")
public class CourseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseSpringDataRepository courseRepository;
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse() {
		Course course = courseRepository.save(new Course("KOPS with Test"));
		if(course !=null) {
			return "Course added";
		}else {
			return "Course not added";
		}
	}
	
	@GetMapping("/findAllCourses")
	public List<Course> getBooks() {
		return courseRepository.findAll();
	}
	
}
