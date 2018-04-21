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
import edu.northeastern.cs5200.models.Eventee;
import edu.northeastern.cs5200.models.Ticket;
import edu.northeastern.cs5200.repositories.EventRepository;
import edu.northeastern.cs5200.repositories.EventeeRepository;
import edu.northeastern.cs5200.repositories.TicketRepository;

@RestController
public class TicketService {
	
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	EventeeRepository eventeeRepository;
	
	//CREATE A TICKET
	@PostMapping("/api/event/{eventId}/eventee/{eventeeId}/ticket")
	public Ticket createTicket(@PathVariable("eventId") int eid,
			@PathVariable("eventeeId") int eventeeid,
			@RequestBody Ticket ticket) {
		
		Event event = eventRepository.findOne(eid);
		Eventee eventee = eventeeRepository.findOne(eventeeid);
		
		ticket.setEvent(event);
		ticket.setEventee(eventee);
		
		return ticketRepository.save(ticket);
	}
	
	// FIND ALL TICKETS
	// FOR AN EVENT IF PROVIDED
	// ELSE FIND ALL TICKETS
	@GetMapping("/api/ticket")
	public List<Ticket> findAllTickets(@RequestParam 
		(name = "eventId", required=false) Integer eid){
		if(eid != null) {
			Event e = eventRepository.findOne(eid);
			return e.getTicket();
		}
		return (List<Ticket>) ticketRepository.findAll();
	}
	
	// FIND TICKET By ID
	@GetMapping("/api/ticket/{ticketId}")
	public Ticket findTicketById(
			@PathVariable("ticketId") int tid){
		
		return ticketRepository.findOne(tid);
	}
	
	// UPDATE TICKET 
	@PutMapping("/api/event/ticket/{ticektId}")
	public Ticket updateTicket(@PathVariable("ticketId") int tid,
			Ticket ticket) {
		Ticket t = ticketRepository.findOne(tid);
		if(ticket.getEvent()!=null)
			t.setEvent(ticket.getEvent());
		if(ticket.getEventee()!=null)
			t.setEventee(ticket.getEventee());
		if(ticket.getPrice() != 0 )   // need to check ??
			t.setPrice(ticket.getPrice());
		if(ticket.getReview()!=null)
			t.setReview(ticket.getReview());
		
		return ticketRepository.save(t);
	}
	
	
	// DELETE TICKET
	@DeleteMapping("/api/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") int tid) {
		
		ticketRepository.delete(tid);
		
	}
	

}
