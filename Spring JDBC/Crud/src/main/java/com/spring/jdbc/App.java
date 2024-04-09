package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started........." );
        
        //Xml configuration
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

//        Annotation configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfigUsingAnno.class);
        StudentDao dao = context.getBean("studentDao",StudentDao.class);
        
       
        Student student = new Student();
        
        //inserting data
      
//        student.setId(222);
//        student.setName("john");
//        student.setAddress("lukhnau");
//        
//         int result = dao.insert(student);
//        System.out.println("record inserted...");
//        System.out.println(result);
        
        //updating data
//        student.setId(101);			 	//old id
//        student.setName("Abhi");		//new name
//        student.setAddress("Junner");	//new Address  
//        int result = dao.change(student);
//        System.out.println("record updated...");
        
        //deleting data
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter value to delete row");
//        int id = sc.nextInt();
        //int result = dao.delete(id);
        
        //or
//        int result = dao.delete(101);
//        System.out.println("record deleted....");
//        System.out.println(result);
//      
        
        //select sigle object
//        Student student1 = dao.getStudent(102);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter your id to print records");
//        int studentId = sc.nextInt();
//        
//        Student student1 = dao.getStudent(studentId);
//        System.out.println(student1);
        
        //All object select
        List<Student> students = dao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s);
        }
        
    }
}
