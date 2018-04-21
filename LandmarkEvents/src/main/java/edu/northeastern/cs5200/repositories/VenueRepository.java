package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Venue;

public interface VenueRepository extends CrudRepository<Venue, Integer>{

}
