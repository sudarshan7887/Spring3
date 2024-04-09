package com.spring.restjpa.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.restjpa.Entities.Student;
import com.spring.restjpa.dao.StudentRepo;

@Component
public class StudentService 
{
	@Autowired
	private	 StudentRepo studentRepo;
	
	//get All Students
	public List<Student> getAllStudent()
	{
		List<Student> list = (List<Student>)this.studentRepo.findAll();
		return list;
	}
	
	//Get Single Student
	public Student getStudentById(int id)
	{
		Student student = null;
		try{
			student = this.studentRepo.findById(id);	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return student;
	}
	
	//Add Student
	public Student addStudent(Student stud)
	{
		Student s = studentRepo.save(stud);
		return s;
	}
	
	//Delete Student
	public void deleteStudent(int id)
	{
		studentRepo.deleteById(id);		
	}
	
	//update Student
	public void updateStudent(Student student,int id)
	{
		student.setId(id);
		studentRepo.save(student);
	}
	
}
