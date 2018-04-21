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
		@PostMapping("/api/host/{userId}/event")
		public Event createEventForHost(@RequestBody Event event, @PathVariable("userId") int userId) {
			Host n = hostRepository.findOne(userId);
			event.setHost(n);
			return eventRepository.save(event);
		}
		
		
		/** 
		 * 
		 * @param performer
		 * @param eventId
		 * @return
		 */
		@PutMapping("/api/event/{eventId}/performer")
		public Event addPerformerToEvent(@RequestBody Performer performer,  @PathVariable("eventId") int eventId) {
			Event e = eventRepository.findOne(eventId);
			e.getPerformers().add(performer);
			return e;
		}
		
		/** 
		 * 
		 * @param performer
		 * @param eventId
		 * @return
		 */
		@DeleteMapping("/api/event/{eventId}/performer")
		public Event removePerformerForEvent(@RequestBody Performer performer,  @PathVariable("eventId") int eventId) {
			Event e = eventRepository.findOne(eventId);
			e.getPerformers().remove(performer);
			return e;
		}
		
		/** 
		 * 
		 * @param hostId
		 * @param venueId
		 * @param performerId
		 * @param cityName
		 * @return
		 */
		
		@GetMapping("/api/host/event")
		public List<Event> getAllEvents(@RequestParam(name="hostId", required=false)
				Integer hostId, @RequestParam(name="venueId", required=false)
		Integer venueId, @RequestParam(name="performerId", required=false)
		Integer performerId, @RequestParam(name="cityName", required=false)
		String cityName){
			
			if(venueId == null && hostId!=null && performerId == null && cityName == null) {
				Host n = hostRepository.findOne(hostId);
				return (List<Event>) eventRepository.findEventByHost(n);
			} else if(venueId != null && hostId==null && performerId == null && cityName == null) {
				Venue v = venueRepository.findOne(venueId);
				return (List<Event>) eventRepository.findEventByVenue(v);
			} else if(venueId == null && hostId==null && performerId != null && cityName == null) {
				Performer p = performerRepository.findOne(performerId);
				return p.getEvents();
			} else if(venueId == null && hostId==null && performerId == null && cityName != null) {
				return (List<Event>) eventRepository.findEventByCity(cityName);
			}
			else if(venueId == null && hostId==null && performerId == null && cityName == null){
				return (List<Event>) eventRepository.findAll();
				
			} else {
				return new ArrayList();
			}

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
			if(e.getTitle()!=null)
				e.setTitle(event.getTitle());
			if(event.getHrs()!=0)
				e.setHrs(event.getHrs());
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
