package com.sudarshan;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MethodsDemo implements DisposableBean,InitializingBean
{
	private int id ;
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
		return "MethodsDemo [id=" + id + ", name=" + name + "]";
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init Method in Spring Lifecycle");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy Method in Spring Lifecycle");
		
	}
	
	

	
}
