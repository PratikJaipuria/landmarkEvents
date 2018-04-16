package edu.northeastern.cs5200.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Host;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.HostRepository;


@RestController
public class HostService {
	
	@Autowired
	HostRepository hostRepository;
	
	@PostMapping("/api/host")
	public Host createHost(
			@RequestBody Host host) {
		
		return hostRepository.save(host);
	}

}
