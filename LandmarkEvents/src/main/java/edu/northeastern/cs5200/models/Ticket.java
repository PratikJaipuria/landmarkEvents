package edu.northeastern.cs5200.models;
import javax.persistence.*;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne
	private Event event;
	
	@OneToOne
	private Eventee eventee;
	
	
	private double price;
	
	@OneToOne
	private Review review;
	
	

	public Review getReview() {
		return review;
	}


	public void setReview(Review review) {
		this.review = review;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}


	public Eventee getEventee() {
		return eventee;
	}


	public void setEventee(Eventee eventee) {
		this.eventee = eventee;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Ticket() {

	}
	
	
	
	
}
