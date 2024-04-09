package com.spring.restjpa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String Name;
	private String City;
	private String Info;
	
	public Student() 
	{
		super();
	}

	public Student(int id, String name, String city, String info) {
		super();
		id = id;
		Name = name;
		City = city;
		Info = info;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}

	@Override
	public String toString() {
		return "Student [Id=" + id + ", Name=" + Name + ", City=" + City + ", Info=" + Info + "]";
	}
	
	
}
