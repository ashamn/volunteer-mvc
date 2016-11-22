package com.vtracker.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="volunteer")
public class Volunteer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int id;
	
	@Column(name="first_name")
	public String firstName;
	
	@Column(name="last_name")
	public String lastName;
	
	@Column(name="age")
	public int age;
	
	@Enumerated(EnumType.ORDINAL)
	public Gender gender;
	
	@Column(name="email")
	public String email;
	
	@Column(name="mobile_number")
	public String mobile_number;
	
	@Column(name="date_started")
	@Type(type="date")
	public Date dateStarted;
	
	@Enumerated(EnumType.ORDINAL)
	public Status status;

	public Volunteer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", email=" + email + ", mobile_number=" + mobile_number + ", dateStarted=" + dateStarted + ", status="
				+ status + "]";
	}



	
	
	
}
