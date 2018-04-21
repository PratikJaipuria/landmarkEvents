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

import edu.northeastern.cs5200.models.Event;
import edu.northeastern.cs5200.models.Review;
import edu.northeastern.cs5200.models.Ticket;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.repositories.EventRepository;
import edu.northeastern.cs5200.repositories.ReviewRepository;
import edu.northeastern.cs5200.repositories.TicketRepository;

@RestController
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	EventRepository eventRepository;
	
	
	@PostMapping("/api/ticket/{ticketId}/review")
	public Review createReview(@PathVariable("ticketId") int tid,
			@RequestBody Review review) {
		Ticket t = ticketRepository.findOne(tid);
		review.setTicket(t);
		return reviewRepository.save(review);
	}
	
	// FIND ALL REVIEWS
	// FOR AN EVENT IF PROVIDED
	// ELSE RETURN ALL REVIEWS
	@GetMapping("/api/event/{eventId}/review")
	public List<Review> findAllReviews(@RequestParam 
		(name = "eventId", required=false) Integer eid){
		
		if(eid != null) {
			Event e = eventRepository.findOne(eid);
			
			 List<Ticket> tickets = e.getTicket();
			 List<Review> eventReviews = new ArrayList<Review>();
			
			 for(Ticket t : tickets) 
				 eventReviews.add(t.getReview());
			 
			 return eventReviews;
				
		}
		
		return (List<Review>) reviewRepository.findAll();
	}
	
	// FIND REVIEW By ID
	@GetMapping("/api/review/{reviewId}")
	public Review findReviewById(
			@PathVariable("reviewId") int rid){
		
		return reviewRepository.findOne(rid);
	}
	
	// UPDATE REVIEW
	@PutMapping("/api/ticket/review/{reviewId}")
	public Review updateReview(@PathVariable("reviewId") int rid,
			Review review) {
		Review r = reviewRepository.findOne(rid);
		if(review.getDescription()!=null)
			r.setDescription(review.getDescription());
		if(review.getTicket()!=null)
			r.setTicket(review.getTicket());
		if(review.getTitle() != null)
			r.setTitle(review.getTitle());
		
		return reviewRepository.save(r);
	}
	
	// DELETE REVIEW
	@DeleteMapping("/api/ticket/review/{reviewId}")
	public void deleteTicket(@PathVariable("reviewId") int rid) {
		
		reviewRepository.delete(rid);
		
	}
	
	
}
