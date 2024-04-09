package com.spring.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.jpa.enities.User;

public interface UserRepository extends CrudRepository<User, Integer> 
{

	//Custom finder methods or derived query methods
	
	List<User> findByName(String name);
	List<User> findByCityOrName(String city, String name);
	
	//create custom query
	
	//JPQL Query or HQL
	@Query("Select u from User u")
	public List<User> getAll();
	
	@Query("select u from User u where u.name=:n")
	public List<User> getUserByName(@Param("n") String name);
	
	@Query("select u from User u where u.name=:n and u.city =:c")
	public List<User> getUsers(@Param("n") String name , @Param("c") String city);
	
	
	//Native Query or SQL
	
	@Query(value="Select * from User", nativeQuery = true)
	public List<User> getallusers();
}
