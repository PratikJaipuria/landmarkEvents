package edu.northeastern.cs5200.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Eventee;
import edu.northeastern.cs5200.repositories.EventeeRepository;

@RestController
public class EventeeService {
	
	@Autowired
	EventeeRepository eventeeRepository;
	
	//CREATE AN EVENTEE
	@PostMapping("/api/eventee")
	public Eventee createEventee(
			@RequestBody Eventee eventee) {
		
		return eventeeRepository.save(eventee);
	}
	
	//FIND AN EVENTEE WITH USERNAME OR CREDENTIAL IF PROVIDED
	//ELSE
	//FIND ALL USERS
	@GetMapping("/api/eventee")
	public List<Eventee> findAllEventees(
			@RequestParam(name="username", required=false)
				String username,
			@RequestParam(name="password", required=false)
				String password) {
		if(username != null && password != null) {
			return (List<Eventee>) eventeeRepository.findEventeeByCredentials(username, password);
		}
		else if(username != null) {
			return (List<Eventee>) eventeeRepository.findEventeeByUsername(username);
		}
		return (List<Eventee>) eventeeRepository.findAll();
	}
	
	//FIND AN EVENTEE BY ID
	@GetMapping("/api/eventee/{eventeeId}")
	public Eventee findEventeeById(
			@PathVariable("eventeeId") int eid) {
		return eventeeRepository.findOne(eid);
	}
	
	//UPDATE AN EVENTEE
	@PutMapping("/api/eventee/{eventeeId}")
	public Eventee updateEventee(@PathVariable("eventeeId") int eid,
			@RequestBody Eventee eventee) {
		Eventee e = eventeeRepository.findOne(eid);
		
		if(eventee.getFirstName()!=null)
			e.setFirstName(eventee.getFirstName());
		if(eventee.getLastName()!=null)
			e.setLastName(eventee.getLastName());
		if(eventee.getUserName()!=null)
			e.setUserName(eventee.getUserName());
		if(eventee.getPassword()!=null)
			e.setPassword(eventee.getPassword());
		
		return eventeeRepository.save(e);
		
	}

	//DELETE AN EVENTEE
	@DeleteMapping("/api/eventee/{eventeeId}")
	public void deleteEventee(@PathVariable("eventeeId") int eid) {
		eventeeRepository.delete(eid);
		
	}
	
}
