package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	@JsonIgnore
	private Host host = null;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Ticket> ticket = null;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name="Event2Performer",joinColumns=@JoinColumn(name="EventId", referencedColumnName="ID"), 
			inverseJoinColumns=@JoinColumn(name="PerformerId", referencedColumnName="ID"))
	private List<Performer> performers = null;
	
	@ManyToOne
	@JsonIgnore
	private Venue venue = null;
	
	private String url;
	
	private String cityName;
	
	private String category;
	
	private Date startTime;
	
	private String title;
	
	private boolean allDay;
	
	private int hrs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Host getHost() {
		return host;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	public List<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}


	public List<Performer> getPerformers() {
		if(performers == null)
			return new ArrayList<Performer>();
		return performers;
	}

	public void setPerformers(List<Performer> performers) {
		this.performers = performers;
		for(Performer p: performers) {
			p.getEvents().add(this);
		}
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public Event() {
		
	}

}
