package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Eventee extends User {
	
	@OneToOne
	private Ticket ticket;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="Performer2Eventee",joinColumns=@JoinColumn(name="EventeeId", referencedColumnName="ID"), 
			inverseJoinColumns=@JoinColumn(name="PerformerId", referencedColumnName="ID"))
	
	private List<Performer> entertainers;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<Performer> getEntertainers() {
		
		if(entertainers==null)
			return new ArrayList<Performer>();
		return entertainers;
		
	}

	public void setEntertainers(List<Performer> entertainers) {
		this.entertainers = entertainers;
		for(Performer p: entertainers) {
			p.getEventees().add(this);
		}
	}

	public Eventee() {
		super();
	}


	
	

}
