package com.marketing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity:This annotation describes that this is a Special class whose object data will be stored in DB table, Entity=Table in DB
//@Table:Annotation should be used when table name needed in DB is different than class name.
@Entity
@Table(name = "leads")
public class Lead {
	
//@Id:It is declares that this is a primary Key.
//@GeneratedValue: It is declares that the Id has primary & auto increment in its value.
//@Column: Annotation should be used when column name needed in DB is different than method name, it shouldn't have null value.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName;
	@Column(name = "email", nullable = false, length = 128, unique = true)
	private String email;
	@Column(name = "mobile", nullable = false, length = 14, unique = true)
	private String mobile;

//Generate Getter and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
}
