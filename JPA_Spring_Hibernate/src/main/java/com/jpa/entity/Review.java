package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String rating;

	private String description;

	@ManyToOne
	// this is the owning side of relation, so id of course should be present here
	// and mapped by in course class
	// By default, this is eager fetch, on the many side of one to many relation,
	// bcoz this has just one object to be fetched
	private Course course;

	protected Review() {
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description);
	}
}
