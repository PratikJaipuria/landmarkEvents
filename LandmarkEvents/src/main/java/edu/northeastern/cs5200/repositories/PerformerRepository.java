package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Eventee;
import edu.northeastern.cs5200.models.Performer;

public interface PerformerRepository extends CrudRepository<Performer, Integer>{
	
	@Query("SELECT p FROM Performer p WHERE p.userName=:username AND p.password=:password")
	Iterable<Performer> findPerformerByCredentials(
			@Param("username") String username, 
			@Param("password") String password);
	
	@Query("SELECT p FROM Performer p WHERE p.userName=:username")
	Iterable<Performer> findPerformerByUsername(@Param("username") String username);

//	@Query("SELECT p.eventees FROM Performer p WHERE p.performer=:performer")
//	Iterable<Eventee> findfollowersById(@Param("performer") Performer performer);


}
