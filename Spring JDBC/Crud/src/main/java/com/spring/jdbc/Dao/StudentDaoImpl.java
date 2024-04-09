package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

private JdbcTemplate jdbcTemplate;
	
//insert method
	public int insert(Student student)
	{
		//Inserting Data
		String query = "insert into student(id,name,address)values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getAddress());
		return r;	
		
	}
	
	//change method
	public int change(Student student)
	{
		//updating data
		String query = "update student set name =?,address=? where id =?";
		int r = this.jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getId());
		return r;
	}
	
	//delete method
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}
	
	//Select single object
	public Student getStudent(int studentId)
	{
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}
	
	
	//Select all objects
	@Override
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}
	//getter and setter 
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
}
