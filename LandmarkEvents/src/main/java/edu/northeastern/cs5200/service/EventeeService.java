package edu.northeastern.cs5200.service;

import java.util.ArrayList;
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
import edu.northeastern.cs5200.models.Performer;
import edu.northeastern.cs5200.repositories.EventeeRepository;
import edu.northeastern.cs5200.repositories.PerformerRepository;

@RestController
public class EventeeService {
	
	@Autowired
	EventeeRepository eventeeRepository;
	
	@Autowired
	PerformerRepository performerRepository;
	
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

	/**
	 * 
	 * @param eid
	 * @return
	 */
	@PutMapping("/api/eventee/{eid}/performer")
	public Eventee followPerformer(@PathVariable("eid") int eid,
		@RequestBody Performer performer) {
	
	Eventee eventee = eventeeRepository.findOne(eid);
	List<Performer> entertainers = eventee.getEntertainers();
	entertainers.add(performer);
	eventee.setEntertainers(entertainers);
	return eventeeRepository.save(eventee);
	}
	
	@PutMapping("/api/eventee/{eid}/unfollowperformer")
	public Eventee unfollowPerformer(@PathVariable("eid") int eid,
		@RequestBody Performer performer) {
	
	Eventee eventee = eventeeRepository.findOne(eid);
	Performer p = performerRepository.findOne(performer.getId());
	List<Performer> entertainers = eventee.getEntertainers();
	entertainers.remove(p);
	eventee.setEntertainers(entertainers);
	return eventeeRepository.save(eventee);
	}
	
	@GetMapping("api/eventee/{eventeeId}/notfollowing")
	public List<Performer> getListPerformerEventeeNotFollowing(
			@PathVariable("eventeeId") int eid){
		List<Performer> allperformers = (List<Performer>) performerRepository.findAll();
		Eventee eventee = eventeeRepository.findOne(eid);
		List<Performer> following = eventee.getEntertainers();
		for(Performer p:following) {
			allperformers.remove(p);
		}
		return allperformers;
	}
	
	@PutMapping("/api/eventee/{eid}/performer/{pid}")
	public Eventee unfollowPerformer(@PathVariable("eid") int eid,
			@PathVariable("pid") int pid) {
	
	Eventee eventee = eventeeRepository.findOne(eid);
	Performer performer = performerRepository.findOne(pid);
	
	List<Performer> entertainers = eventee.getEntertainers();
	entertainers.add(performer);
	eventee.setEntertainers(entertainers);
	
	List<Eventee> eventees = performer.getEventees();
	eventees.remove(eventee);
	performer.setEventees(eventees);
	
	performerRepository.save(performer);
	
	return eventeeRepository.save(eventee);
	}
	
	
	//FIND ALL Performers followed BY Eventee ID
	@GetMapping("/api/eventee/{eventeeId}/performer")
	public List<Performer> findPerformerFollowedById(
			@PathVariable("eventeeId") int eid) {
		Eventee eventee = eventeeRepository.findOne(eid);
		List<Performer> entertainers = eventee.getEntertainers();
		
		return entertainers;
	}
		
	//DELETE AN EVENTEE
	@DeleteMapping("/api/eventee/{eventeeId}")
	public void deleteEventee(@PathVariable("eventeeId") int eid) {
		eventeeRepository.delete(eid);
		
	}
	
}
