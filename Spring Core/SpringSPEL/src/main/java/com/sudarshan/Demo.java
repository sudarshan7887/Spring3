package com.sudarshan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo 
{
	//@Value("#{12 + 23}")
	private int id;
	
	
	private String name;
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
	@Override
	public String toString() {
		return "SPEL [id=" + id + ", name=" + name + "]";
	}
	
	
}
