package edu.northeastern.cs5200.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import edu.northeastern.cs5200.models.Ticket;
import edu.northeastern.cs5200.repositories.TicketRepository;

@RestController
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	
	//CREATE A TICKET
	@PostMapping("/api/event/{id}/ticket")
	public Ticket createTicket(
			@RequestBody Ticket ticket) {
		
		return ticketRepository.save(ticket);
	}
	
	// FIND ALL TICKETS
	@GetMapping("/api/ticket")
	public List<Ticket> findAllTickets(){
		
		return (List<Ticket>) ticketRepository.findAll();
	}
	
	// FIND ALL TICKETS
	@GetMapping("/api/ticket/{ticketId}")
	public List<Ticket> findTicketById(
			@PathVariable("ticketId") int tid){
		
		return (List<Ticket>) ticketRepository.findOne(tid);
	}
	

}
