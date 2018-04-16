package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Host extends User {
	
	@ManyToMany(mappedBy="hosts", cascade=CascadeType.ALL)
	private List<Event> eventsHosted = null;

}
