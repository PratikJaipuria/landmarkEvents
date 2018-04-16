package edu.northeastern.cs5200.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Event {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Event2Host")
	private List<Host> hosts = null;

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
