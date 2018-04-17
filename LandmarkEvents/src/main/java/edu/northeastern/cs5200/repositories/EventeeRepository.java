package edu.northeastern.cs5200.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Eventee;
import edu.northeastern.cs5200.models.User;

public interface EventeeRepository extends CrudRepository<Eventee, Integer>{

	@Query("SELECT e FROM Eventee e WHERE e.userName=:username AND e.password=:password")
	Iterable<Eventee> findEventeeByCredentials(
			@Param("username") String username, 
			@Param("password") String password);
	
	@Query("SELECT e FROM Eventee e WHERE e.userName=:username")
	Iterable<Eventee> findEventeeByUsername(@Param("username") String username);

}
