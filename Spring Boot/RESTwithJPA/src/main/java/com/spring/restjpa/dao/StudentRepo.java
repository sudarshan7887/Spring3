package com.spring.restjpa.dao;


import org.springframework.data.repository.CrudRepository;

import com.spring.restjpa.Entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> 

{
//	custom finder methods
	public Student findById(int id);
}
