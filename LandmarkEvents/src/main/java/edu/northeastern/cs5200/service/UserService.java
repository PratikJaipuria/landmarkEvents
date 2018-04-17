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

import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.UserRepository;

@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	//CREATE NEW USER
	@PostMapping("/api/user")
	public User createUser(
			@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//FIND USER BY USERNAME OR CREDENTIALS IF PROVIDED
	//ELSE
	//FIND ALL USERS
	@GetMapping("/api/user")
	public List<User> findAllUsers(
			@RequestParam(name="username", required=false)
				String username,
			@RequestParam(name="password", required=false)
				String password) {
		if(username != null && password != null) {
			return (List<User>) userRepository.findUserByCredentials(username, password);
		}
		else if(username != null) {
			return (List<User>) userRepository.findUserByUsername(username);
		}
		return (List<User>) userRepository.findAll();
	}
	
	//FIND USER BY USER ID
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") int uid) {
		return userRepository.findOne(uid);
	}
	
	//UPDATE USER
	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int id,
			@RequestBody User user) {
		User uN = userRepository.findOne(id);
		
		if(user.getFirstName()!=null)
			uN.setFirstName(user.getFirstName());
		if(user.getLastName()!=null)
			uN.setLastName(user.getLastName());
		if(user.getUserName()!=null)
			uN.setUserName(user.getUserName());
		if(user.getPassword()!=null)
			uN.setPassword(user.getPassword());
		
		return userRepository.save(uN);
		
	}
		
	//DELETE USER
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		userRepository.delete(id);
		
	}	
	
}
