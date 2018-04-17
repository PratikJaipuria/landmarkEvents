package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Host extends User {
	
	@ManyToMany(mappedBy="hosts", cascade=CascadeType.ALL)
	@JsonIgnore

	private List<Event> eventsHosted = null;

	public List<Event> getEventsHosted() {
		return eventsHosted;
	}

	public void setEventsHosted(List<Event> eventsHosted) {
		this.eventsHosted = eventsHosted;
	}
	
	
}
