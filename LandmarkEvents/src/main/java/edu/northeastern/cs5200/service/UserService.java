package edu.northeastern.cs5200.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.repositories.UserRepository;

@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
}
