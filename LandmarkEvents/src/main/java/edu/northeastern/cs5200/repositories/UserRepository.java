package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.userName=:username AND u.password=:password")
	Iterable<User> findUserByCredentials(
			@Param("username") String username, 
			@Param("password") String password);
	
	@Query("SELECT u FROM User u WHERE u.userName=:username")
	Iterable<User> findUserByUsername(@Param("username") String u);
}
