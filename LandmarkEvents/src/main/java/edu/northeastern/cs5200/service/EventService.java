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
import edu.northeastern.cs5200.models.Host;
import edu.northeastern.cs5200.models.Performer;
import edu.northeastern.cs5200.models.Venue;
import edu.northeastern.cs5200.repositories.EventRepository;
import edu.northeastern.cs5200.repositories.HostRepository;
import edu.northeastern.cs5200.repositories.PerformerRepository;
import edu.northeastern.cs5200.repositories.VenueRepository;

/** 
 * 
 * @author varunnandu
 *
 */
@RestController
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	HostRepository hostRepository;
	
	@Autowired
	VenueRepository venueRepository;
	
	@Autowired
	PerformerRepository performerRepository;
	
		
	/** 
	 * 
	 * @param event
	 * @param userId
	 * @return
	 */
		@PostMapping("/api/host/{userId}/venue/{venueId}/event")
		public Event createEventForHost(@RequestBody Event event, 
				@PathVariable("userId") int userId,
				@PathVariable("venueId") int vid) {
			Host n = hostRepository.findOne(userId);
						
			event.setHost(n);
			Venue v  = venueRepository.findOne(vid);
			event.setVenue(v);
			
			return eventRepository.save(event);
		}
		
		
		/** 
		 * 
		 * @param performer
		 * @param eventId
		 * @return
		 */
		@PutMapping("/api/host/event/{eventId}/performer")
		public Event addPerformerToEvent(@RequestBody Performer performer,  @PathVariable("eventId") int eventId) {
			Event e = eventRepository.findOne(eventId);
			List<Performer> tmplist = e.getPerformers();
			tmplist.add(performer);
			e.setPerformers(tmplist);

			return eventRepository.save(e);
		}
		
		/** 
		 * 
		 * @param performer
		 * @param eventId
		 * @return
		 */
		@PutMapping("/api/host/event/{eventId}/performer/{performerId}")
		public Event removePerformerForEvent(@PathVariable("performerId") int performerId,  @PathVariable("eventId") int eventId) {
			
			Event e = eventRepository.findOne(eventId);
			Performer p = performerRepository.findOne(performerId);
			
			List<Performer> performers = e.getPerformers();
			
			performers.remove(p);	
			e.setPerformers(performers);
			
			return eventRepository.save(e);
		}
		
		/**
		 * 
		 * @param venue
		 * @param eventId
		 * @return
		 */
		@PutMapping("/api/event/{eventId}/venue/{venueId}")
		public Event addVenueToEvent( 
				@PathVariable("eventId") int eventId,
				@PathVariable("venueId") int venueId) {
			
			Event e = eventRepository.findOne(eventId);
			Venue v = venueRepository.findOne(venueId);
			
			e.setVenue(v);

			return eventRepository.save(e);
		}
		
		/** 
		 * 
		 * @param hostId
		 * @param venueId
		 * @param performerId
		 * @param cityName
		 * @param category
		 * @return
		 */
		
		@GetMapping("/api/host/event")
		public List<Event> getAllEvents(@RequestParam(name="hostId", required=false)
				Integer hostId, @RequestParam(name="venueId", required=false)
		Integer venueId, @RequestParam(name="performerId", required=false)
		Integer performerId, @RequestParam(name="cityName", required=false)
		String cityName, @RequestParam(name="category", required=false)
		String category){
			
			if(venueId == null && hostId!=null && performerId == null && cityName == null && category== null) {
				Host n = hostRepository.findOne(hostId);
				return (List<Event>) eventRepository.findEventByHost(n);
			} else if(venueId != null && hostId==null && performerId == null && cityName == null && category== null) {
				Venue v = venueRepository.findOne(venueId);
				return v.getEvents();
			} else if(venueId == null && hostId==null && performerId != null && cityName == null && category== null) {
				Performer p = performerRepository.findOne(performerId);
				return p.getEvents();
			} else if(venueId == null && hostId==null && performerId == null && cityName != null && category== null) {
				return (List<Event>) eventRepository.findEventByCity(cityName);
			}
			else if(venueId == null && hostId==null && performerId == null && cityName == null && category== null){
				return (List<Event>) eventRepository.findAll();
				
			} else if(venueId == null && hostId==null && performerId == null && cityName != null && category!= null){
				return (List<Event>) eventRepository.findEventByCityCategory(cityName, category);
				
			} else if(venueId == null && hostId==null && performerId == null && cityName == null && category!= null){
				return (List<Event>) eventRepository.findEventByCategory(category);
				
			} else {
				return new ArrayList();
			}

		}
		
		// FIND EVENT BY ID
		@GetMapping("/api/event/{eventId}")
		public Event findEventById(
				@PathVariable("eventId") int eventId) {
			Event e = eventRepository.findOne(eventId);
			return e;
		}
		
		/** 
		 * 
		 * @param eid
		 * @param eventee
		 * @return
		 */
		@PutMapping("/api/host/event/{eventId}")
		public Event updateEvent(@PathVariable("eventId") int eventId,
				@RequestBody Event event) {
			Event e = eventRepository.findOne(eventId);
			
			if(event.getCityName()!=null)
				e.setCityName(event.getCityName());
			if(event.getStartTime()!=null)
				e.setStartTime(event.getStartTime());
			if(event.getEndTime()!=null)
				e.setEndTime(event.getEndTime());
			if(event.getTitle()!=null)
				e.setTitle(event.getTitle());
			if(event.getVenue()!=null)
				e.setVenue(event.getVenue());
			if(event.getUrl()!=null)
				e.setUrl(event.getUrl());
			
			return eventRepository.save(e);
			
		}

		/** 
		 * 
		 * @param eventId
		 */
		@DeleteMapping("/api/host/event/{eventId}")
		public void deleteEvent(@PathVariable("eventId") int eventId) {
			eventRepository.delete(eventId);
			
		}

}
