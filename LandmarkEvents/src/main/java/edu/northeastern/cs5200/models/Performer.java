package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Performer extends User {
	
	private String bio;
	
	@ManyToMany(mappedBy="performers",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Event> events = null;
	
	@ManyToMany(mappedBy="entertainers")
	@JsonIgnore
	private List<Eventee> eventees = null;

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Event> getEvents() {
		if(events==null)
			return new ArrayList<Event>();	
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
		for(Event e: events) {
			e.getPerformers().add(this);
		}
	}

	public List<Eventee> getEventees() {
		if(eventees==null)
			return new ArrayList<Eventee>();
		return eventees;
	}

	public void setEventees(List<Eventee> eventees) {
		this.eventees = eventees;
		for(Eventee ee: eventees) {
			ee.getEntertainers().add(this);
		}
	}

	public Performer() {
		super();
	}
	
	

	

	
}
