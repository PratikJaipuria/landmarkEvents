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
import edu.northeastern.cs5200.models.Host;
import edu.northeastern.cs5200.models.Performer;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.EventeeRepository;
import edu.northeastern.cs5200.repositories.HostRepository;
import edu.northeastern.cs5200.repositories.PerformerRepository;
import edu.northeastern.cs5200.repositories.UserRepository;


@RestController
public class AdminService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HostRepository hostRepository;
	
	@Autowired
	EventeeRepository eventeeRepository;
	
	@Autowired
	PerformerRepository performerRepository;
	
	//CREATE NEW PERFORMER FOR ADMIN
	@PostMapping("/api/admin/performer")
	public Performer createPerformer(@RequestBody Performer performer) {
		return performerRepository.save(performer);		
	}
	
	//CREATE NEW EVENTEE FOR ADMIN
	@PostMapping("/api/admin/eventee")
	public Eventee createEventee(@RequestBody Eventee eventee) {
		return eventeeRepository.save(eventee);		
	}
	
	//CREATE NEW HOST FOR ADMIN
	@PostMapping("/api/admin/host")
	public Host createHost(@RequestBody Host host) {
		return hostRepository.save(host);		
	}
		
	
	//FIND ALL USERS OF PARTICULAR TYPE FOR ADMIN
	@GetMapping("/api/admin/{type}")
	public List<?> findAllUsers(@PathVariable("type") String type) {
		
		if(type.equals("host"))
			return (List<?>) hostRepository.findAll();
		if(type.equals("eventee"))
			return (List<?>) eventeeRepository.findAll();
		if(type.equals("performer"))
			return (List<?>) performerRepository.findAll();
		if(type.equals("users"))
			return (List<User>) userRepository.findAll();
		return null;
	}
	
	//UPDATE PERFORMER FOR ADMIN
	@PutMapping("/api/admin/performer/{performerId}")
	public Performer updatePerformer(@PathVariable("performerId") int pid,
			@RequestBody Performer performer) {
		Performer p = performerRepository.findOne(pid);
		
		if(performer.getFirstName()!=null)
			p.setFirstName(performer.getFirstName());
		if(performer.getLastName()!=null)
			p.setLastName(performer.getLastName());
		if(performer.getUserName()!=null)
			p.setUserName(performer.getUserName());
		if(performer.getPassword()!=null)
			p.setPassword(performer.getPassword());
		if(performer.getBio() != null)
			p.setBio(performer.getBio());
		
		return performerRepository.save(p);
	}
	
	//UPDATE EVENTEE FOR ADMIN
	@PutMapping("/api/admin/eventee/{eventeeId}")
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
		if(eventee.getTicket()!=null)
			e.setTicket(eventee.getTicket());
		
		return eventeeRepository.save(e);
		
	}
	
	//UPDATE HOST FOR ADMIN
	@PutMapping("/api/admin/host/{hostId}")
	public Host updateHost(@PathVariable("hostId") int hid,
			@RequestBody Host host) {
		Host h = hostRepository.findOne(hid);
		
		if(host.getFirstName()!=null)
			h.setFirstName(host.getFirstName());
		if(host.getLastName()!=null)
			h.setLastName(host.getLastName());
		if(host.getUserName()!=null)
			h.setUserName(host.getUserName());
		if(host.getPassword()!=null)
			h.setPassword(host.getPassword());
		if(host.getCompanyName()!=null)
			h.setCompanyName(host.getCompanyName());
		
		return hostRepository.save(h);
		
	}
	
		
	//DELETE USER
	@DeleteMapping("/api/admin/{type}/{userId}")
	public void deleteUser(@PathVariable("userId") int id,
			@PathVariable("type") String type) {
		if(type.equals("host"))
			hostRepository.delete(id);
		if(type.equals("eventee"))
			eventeeRepository.delete(id);
		if(type.equals("performer"))
			performerRepository.delete(id);
	}

}
