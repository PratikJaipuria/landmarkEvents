package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Eventee extends User {
	
	@ManyToMany(mappedBy="eventess", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Event> eventsVisited= null;
	
	@ManyToOne
	@JsonIgnore
	private Performer perform;

	public List<Event> getEventsVisited() {
		return eventsVisited;
	}

	public void setEventsVisited(List<Event> eventsVisited) {
		this.eventsVisited = eventsVisited;
	}

	public Performer getPerform() {
		return perform;
	}

	public void setPerform(Performer perform) {
		this.perform = perform;
	}

	public Eventee() {
		// TODO Auto-generated constructor stub
	}
	
	

}
