package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Host;

public interface HostRepository extends CrudRepository<Host, Integer>{
	
	@Query("SELECT h FROM Host h WHERE h.userName=:username AND h.password=:password")
	Iterable<Host> findHostByCredentials(
			@Param("username") String username, 
			@Param("password") String password);
	
	@Query("SELECT h FROM Host h WHERE h.userName=:username")
	Iterable<Host> findHostByUsername(@Param("username") String username);
	
	@Query("SELECT h FROM Host h WHERE h.userName=:username")
	Host findHostByEvent(@Param("host") Host host);


	
}
