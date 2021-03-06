package com.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	// mapped by annotation would ensure that passport table does not have student
	// id, but it is mapped to student table by the passport column in student table
	// This is bidirectional relationship, you do not have the column in the table
	// passport because it is not recommended to have 1-1 reln on both sides,
	// student is the owning side of the relationship so it has the passport id.
	// We can retrive the student obj from here using mappedby annotation
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public Student student;

	protected Passport() {
	}

	public Passport(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Passport[%s]", number);
	}

}
