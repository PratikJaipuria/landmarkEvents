package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Performer extends User {
	
	@ManyToMany(mappedBy="performers", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Event> eventsPerformed = null;
	
	@OneToMany(mappedBy="perform", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Eventee> eventees = null;

	public List<Event> getEventsPerformed() {
		return eventsPerformed;
	}

	public void setEventsPerformed(List<Event> eventsPerformed) {
		this.eventsPerformed = eventsPerformed;
	}

	public List<Eventee> getEventees() {
		return eventees;
	}

	public void setEventees(List<Eventee> eventees) {
		this.eventees = eventees;
	}

	public Performer() {
		// TODO Auto-generated constructor stub
	}

	
}
