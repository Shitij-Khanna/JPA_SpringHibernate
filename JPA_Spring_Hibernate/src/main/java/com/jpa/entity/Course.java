package com.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Course")
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c"),
		@NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'") })
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@UpdateTimestamp
	// @UpdateTimestamp : This is provided by Hibernate
	// Save the updated time of the entity
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	// Fetch type is lazy by default for one to many relations, on the side where
	// many relations have to be fetched
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<Review>();

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(final Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}

}
