package edu.northeastern.cs5200.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.ReviewRepository;

@RestController
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	@PostMapping("/api/ticket/{id}/review/")
	public Review createUser(
			@RequestBody Review review) {
		
		return reviewRepository.save(review);
	}
	
	
}
