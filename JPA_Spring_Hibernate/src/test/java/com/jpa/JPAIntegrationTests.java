package com.jpa;

import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.entity.Course;
import com.jpa.repository.CourseSpringDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JPAIntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private CourseSpringDataRepository courseRepository;
	
	@LocalServerPort
    int randomServerPort;

	@Test
	public void findAllCoursesTest() throws JSONException {

		List<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course("Ghost stories"));
		courseList.add(new Course("Ghost stories2"));
		courseList.add(new Course("Ghost stories3"));
		courseList.add(new Course("Ghost stories4"));

//		when(courseRepository.findAll()).thenReturn(courseList);
		
		String response = this.restTemplate.getForObject("/ITschool/course/findAllCourses", String.class);
//		JSONAssert.assertEquals("[{id:2},{id:3},{id:4},{id:5}]", response, false);
		System.out.println(response.toString());
		// verify what URL was used
//        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//        Mockito.verify(restTemplate).getForObject(captor.capture(), Mockito.any(), (Object) Mockito.any());
		// strict is false, means all attributes of json wont be compared
	}

	@Test
	public void addCourseTest() throws JSONException {

		final String baseUrl = "http://localhost:"+randomServerPort+"/ITschool/course/addCourse/";
		URI uri = null;
		 try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		Course course = new Course("Test case");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Course> request = new HttpEntity<>(course, headers);
		ResponseEntity<String> response = this.restTemplate.postForEntity(uri, request,
				String.class);
		System.out.println(response.getBody().toString());
		System.out.println(response.toString());
	}

}
