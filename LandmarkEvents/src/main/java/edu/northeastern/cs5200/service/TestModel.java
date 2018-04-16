package edu.northeastern.cs5200.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestModel {
	
	@Id
    @GeneratedValue
    private Long id;
	private String title;
	private String url;
	private String country;
	
	public TestModel(String title, String url, String country) {
		super();
		this.title = title;
		this.url = url;
		this.country = country;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
}
