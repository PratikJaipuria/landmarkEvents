package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Host;

public interface HostRepository extends CrudRepository<Host, Integer>{
	
}
