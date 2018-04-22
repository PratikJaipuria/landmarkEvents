package edu.northeastern.cs5200.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Event;
import edu.northeastern.cs5200.models.Venue;
import edu.northeastern.cs5200.repositories.EventRepository;
import edu.northeastern.cs5200.repositories.VenueRepository;

@RestController
public class VenueService {
	
	@Autowired
	VenueRepository venueRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	//CREATE NEW VENUE
	@PostMapping("/api/venue")
	public Venue createVenue(
			@RequestBody Venue venue) {
		return venueRepository.save(venue);
	}
	
	
	
	//FIND VENUE BY VENUE ID
	@GetMapping("/api/venue/{venueId}")
	public Venue findVenueById(
			@PathVariable("venueId") int vid) {
		return venueRepository.findOne(vid);
	}
	
	@GetMapping("/api/venue")
	public List<Venue> findAllVenue() {
		return (List<Venue>) venueRepository.findAll();
	}
	
	//UPDATE VENUE
	@PutMapping("/api/venue/{venueId}")
	public Venue updateVenue(@PathVariable("venueId") int vid,
			@RequestBody Venue venue) {
		Venue ven = venueRepository.findOne(vid);
		
		if(venue.getAddress() != null)
			ven.setAddress(venue.getAddress());
		if(venue.getName() != null)
			ven.setAddress(venue.getAddress());
		if(venue.getUrl() != null)
			ven.setUrl(venue.getUrl());
		
		
		return venueRepository.save(ven);
		
	}
		
	//DELETE VENUE
	@DeleteMapping("/api/venue/{venueId}")
	public void deleteVenue(@PathVariable("venueId") int vid) {
		venueRepository.delete(vid);
		
	}
	
	
	

}
