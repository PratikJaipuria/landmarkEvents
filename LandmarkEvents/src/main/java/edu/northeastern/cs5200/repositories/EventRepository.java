package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Event;
import edu.northeastern.cs5200.models.Host;
import edu.northeastern.cs5200.models.Venue;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	@Query("SELECT h FROM Event h WHERE h.host=:host")
	Iterable<Event> findEventByHost(@Param("host") Host host);
	
	@Query("SELECT h FROM Event h WHERE h.venue=:venue")
	Iterable<Event> findEventByVenue(@Param("venue") Venue venue);
	
	@Query("SELECT h FROM Event h WHERE h.cityName=:cityName")
	Iterable<Event> findEventByCity(@Param("cityName") String cityName);
	
	@Query("SELECT h FROM Event h WHERE h.category=:category")
	Iterable<Event> findEventByCategory(@Param("category") String category);
	
	@Query("SELECT h FROM Event h WHERE h.cityName=:cityName and h.category=:category")
	Iterable<Event> findEventByCityCategory(@Param("cityName") String cityName, @Param("category") String category);
	

}
