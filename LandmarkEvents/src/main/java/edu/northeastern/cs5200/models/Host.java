package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Host extends User {
	
	private String companyName;
	
	@OneToMany(mappedBy="host", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Event> eventsHosted = null;

	public List<Event> getEventsHosted() {
		return eventsHosted;
	}

	public void setEventsHosted(List<Event> eventsHosted) {
		this.eventsHosted = eventsHosted;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public Host() {
		super();
	}

	
	
}
