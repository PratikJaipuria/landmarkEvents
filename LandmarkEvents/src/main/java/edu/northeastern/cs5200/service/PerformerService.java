package edu.northeastern.cs5200.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Performer;
import edu.northeastern.cs5200.repositories.PerformerRepository;


@RestController
public class PerformerService {
	
	@Autowired
	PerformerRepository performerRepository;
	
	@PostMapping("/api/performer")
	public Performer createPerformer(
			@RequestBody Performer performer) {
		
		return performerRepository.save(performer);
	}

}
