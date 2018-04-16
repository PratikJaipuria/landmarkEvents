package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="Event2Host", joinColumns=@JoinColumn(name="EventId", referencedColumnName="ID"), 
	inverseJoinColumns=@JoinColumn(name="HostId", referencedColumnName="ID"))
	private List<Host> hosts = null;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="Ticket", joinColumns=@JoinColumn(name="EventId", referencedColumnName="ID"), 
			inverseJoinColumns=@JoinColumn(name="EventeeId", referencedColumnName="ID"))
	private List<Eventee> eventess = null;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="Event2Performer", joinColumns=@JoinColumn(name="EventId", referencedColumnName="ID"), 
			inverseJoinColumns=@JoinColumn(name="PerformerId", referencedColumnName="ID"))
	private List<Performer> performers = null;

	public List<Eventee> getEventess() {
		return eventess;
	}

	public void setEventess(List<Eventee> eventees) {
		this.eventess = eventees;
	}

	public List<Performer> getPerformers() {
		return performers;
	}

	public void setPerformers(List<Performer> performers) {
		this.performers = performers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}

	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	

}
