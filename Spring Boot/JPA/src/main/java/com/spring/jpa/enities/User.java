package com.spring.jpa.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String city;
	private String informaion;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getInformaion() {
		return informaion;
	}
	public void setInformaion(String informaion) {
		this.informaion = informaion;
	}
	public User(int id, String name, String city, String informaion) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.informaion = informaion;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", informaion=" + informaion + "]";
	}
	
	
	
	
}
