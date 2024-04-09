package com.spring.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.jpa.dao.UserRepository;
import com.spring.jpa.enities.User;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);
		
		
		//insert or create data
	
//		User user1 = new User();
//		//user1.setId(101);
//		user1.setName("Sudarshan");
//		user1.setCity("Mumbai");
//		user1.setInformaion("I am a Coder");
//		
//		User user2 = new User();
//		//user2.setId(102);
//		user2.setName("ram");
//		user2.setCity(" navi Mumbai");
//		user2.setInformaion("I am a programmer");
//		
//		User user3 = new User();
//		//user3.setId(103);
//		user3.setName("kiran");
//		user3.setCity("pune");
//		user3.setInformaion("I am a lecturer");
//		
//		//save multiple object
//	
//		List<User> users =List.of(user1,user2,user3);
//		Iterable<User> result = repository.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});
		
		//save single object
//		User user = repository.save(user1);
//		System.out.println(user1);
		
		//update Data		
//		Optional<User> optional =  repository.findById(2);
//		User user = optional.get();
//		user.setCity("Nashik");
//		User result = repository.save(user);
//		System.out.println(result);
		
		
		//Get data
//		Optional<User> optional1 = repository.findById(3);
//		User user1 = optional1.get();
//		System.out.println("Selected user is:"+user1);
//		
//		//Get all Data
//		Iterable<User> it = repository.findAll();
//		it.forEach(User->{
//			System.out.println(User);
//		});
		
		
		
		//delete data
//		repository.delete(user1);
//		System.out.println("deleted.....");
		
		//repository.deleteById(52);
		
		//delete all
//		Iterable<User> itr = repository.findAll();
//		itr.forEach(abc->System.out.println(abc));
//		repository.deleteAll(itr);
//		
		
		
		
//		//Custom finder methods
		
		
//		List<User> users = repository.findByName("ram");
//		users.forEach(e->System.out.println(e));
//		
//		List<User> users1 = repository.findByCityOrName("navi Mumbai", "ram");
//		users1.forEach(e1->System.out.println(e1));
//		
		//custom query call
		List<User> allusers =repository.getAll();
		allusers.forEach(q->System.out.println(q));
		
		System.out.println("----------------------");
		
		List<User> alluserName = repository.getUserByName("ram");
		alluserName.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("+-------------------------------");
		
		List<User> alluser = repository.getUsers("kiran","pune");
		alluser.forEach(e->{
			System.out.println(e);
		});
		
		System.out.println("_____________________________________-");
		
		List<User> u = repository.getallusers();
		u.forEach(e->{
			System.out.println(e);
		});
		
	}

}
