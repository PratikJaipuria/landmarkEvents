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
import edu.northeastern.cs5200.models.Performer;
import edu.northeastern.cs5200.repositories.PerformerRepository;


@RestController
public class PerformerService {
	
	@Autowired
	PerformerRepository performerRepository;
	
	//CREATE A PERFORMER
	@PostMapping("/api/performer")
	public Performer createPerformer(
			@RequestBody Performer performer) {
		
		return performerRepository.save(performer);
	}
	
	//FIND PERFORMER WITH USERNAME OR CREDENTIALS IF PROVIDED
	//ELSE
	//FIND ALL PERFORMERS
	@GetMapping("/api/performer")
	public List<Performer> findAllPerformers(
			@RequestParam(name="username", required=false)
				String username,
			@RequestParam(name="password", required=false)
				String password) {
		if(username != null && password != null) {
			return (List<Performer>) performerRepository.findPerformerByCredentials(username, password);
		}
		else if(username != null) {
			return (List<Performer>) performerRepository.findPerformerByUsername(username);
		}
		return (List<Performer>) performerRepository.findAll();
	}
	
	//FIND A PERFORMER BY ID
	@GetMapping("/api/performer/{performerId}")
	public Performer findPerformerById(
			@PathVariable("performerId") int pid) {
		return performerRepository.findOne(pid);
	}
	
//	List of Users following a performer
//	/** 
//	 * 
//	 * @param pid
//	 * @return
//	 */
	@GetMapping("/api/performer/{performerId}/followers")
	public List<Eventee> findfollowersByPerformer(
			@PathVariable("performerId") int pid) {
		Performer pR = performerRepository.findOne(pid);
		return pR.getEventees();
	}
	
	//UPDATE A PERFORMER
	@PutMapping("/api/performer/{performerId}")
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
		
		return performerRepository.save(p);
		
	}
	
	//DELETE A PERFORMER
	@DeleteMapping("/api/performer/{performerId}")
	public void deletePerformer(@PathVariable("performerId") int pid) {
		performerRepository.delete(pid);
		
	}
	
}
