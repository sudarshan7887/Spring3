package com.spring.restjpa.MainControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.restjpa.Entities.Student;
import com.spring.restjpa.Services.StudentService;

@RestController
public class StudentController 
{

	@Autowired
	private StudentService service;
	
	//Get All Student
			@GetMapping("/student")
			public ResponseEntity<List<Student>> getStudent()
			{
				List<Student> list =this.service.getAllStudent();
				if(list.size()<=0)
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
					return ResponseEntity.of(Optional.of(list));
			}
			
	//Get Single Student
			@GetMapping("/student/{id}")
			public ResponseEntity<Student> getSingleStud(@PathVariable("id") int id)
			{
				Student student =this.service.getStudentById(id);
				if(student == null)
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
					return ResponseEntity.of(Optional.of(student));
			}
	
	//post Student
			@PostMapping("/student")
			public ResponseEntity<Student> postStudent(@RequestBody Student student)
			{
				Student stud = null;
				try
				{
					stud = this.service.addStudent(student);
					return ResponseEntity.status(HttpStatus.CREATED).build();
				}	
				catch(Exception e)
				{
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
			}
	//Delete Student
				@DeleteMapping("/student/{id}")
				public ResponseEntity<Void> deleteStudent(@PathVariable("id") int sid)
				{
					try {
							this.service.deleteStudent(sid);
							return ResponseEntity.status(HttpStatus.OK).build();
						}
					catch(Exception e)
						{
							e.printStackTrace();
							return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
						}
				}
	//Update Student
					@PutMapping("/student/{id}")
					public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id)
					{
						try {
								this.service.updateStudent(student, id);
								return ResponseEntity.ok().body(student);
							}
						catch(Exception e)
						{
							e.printStackTrace();
							return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
						}
						
					}
	}
	

