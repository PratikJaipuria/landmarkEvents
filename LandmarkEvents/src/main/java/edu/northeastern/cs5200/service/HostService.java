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

import edu.northeastern.cs5200.models.Event;
import edu.northeastern.cs5200.models.Host;
import edu.northeastern.cs5200.repositories.EventRepository;
import edu.northeastern.cs5200.repositories.HostRepository;


@RestController
public class HostService {
	
	@Autowired
	HostRepository hostRepository;
	
	@Autowired
	EventRepository eventrepository;
	
	//CREATE A HOST
	@PostMapping("/api/host")
	public Host createHost(
			@RequestBody Host host) {
		
		return hostRepository.save(host);
	}
	
	//FIND HOST WITH USERNAME OR CREDENTIALS IF PROVIDED
	//ELSE
	//FIND ALL HOSTS
	@GetMapping("/api/host")
	public List<Host> findAllHosts(
			@RequestParam(name="username", required=false)
				String username,
			@RequestParam(name="password", required=false)
				String password) {
		if(username != null && password != null) {
			return (List<Host>) hostRepository.findHostByCredentials(username, password);
		}
		else if(username != null) {
			return (List<Host>) hostRepository.findHostByUsername(username);
		}
		return (List<Host>) hostRepository.findAll();
	}
	
	//FIND A HOST BY ID
	@GetMapping("/api/host/{hostId}")
	public Host findHostById(
			@PathVariable("hostId") int hid) {
		return hostRepository.findOne(hid);
	}
	
	/** 
	 * Find Host By Event ID.
	 * @param eventId
	 * @return
	 */
	@GetMapping("/api/event/{eventId}/host")
	public Host findHostByEventId(
			@PathVariable("eventId") int eventId) {
		Event e = eventrepository.findOne(eventId);
		return e.getHost();
	}
	
	//UPDATE A HOST
	@PutMapping("/api/host/{hostId}")
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
		
		return hostRepository.save(h);
		
	}
		
	//DELETE A HOST
	@DeleteMapping("/api/host/{hostId}")
	public void deleteHost(@PathVariable("hostId") int hid) {
		hostRepository.delete(hid);
		
	}
	
	

}
