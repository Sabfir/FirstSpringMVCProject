package com.opinta.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class Student {
	@Size(min=5, max=15
//			, message="please enter the name with the length between {min} and {max} characters"
			)
	private String name;
	private Date DOB;
	private Integer IQ;
	private List<String> hobbies;
	private Address address;

	public Student() {}
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public Integer getIQ() {
		return IQ;
	}
	public void setIQ(Integer iQ) {
		IQ = iQ;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
