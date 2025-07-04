package com.example.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="url_shortner")
public class URLShortner {
	
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="longUrl",nullable = false)
	private String longURL;
	
	@Column(name="shortUrl",nullable=false)
	private String shortURL;
	
	@Column(name="creationTs")
	private LocalDateTime creationTS;
	
	@Column(name="expiryTs")
	private LocalDateTime expiryTS;
	public URLShortner(String longURL, String shortURL, LocalDateTime expiryTS) {
		super();
		this.longURL = longURL;
		this.shortURL = shortURL;
		this.creationTS = LocalDateTime.now();
		this.expiryTS = expiryTS;
	}
	public String getLongURL() {
		return longURL;
	}
	public void setLongURL(String longURL) {
		this.longURL = longURL;
	}
	public String getShortURL() {
		return shortURL;
	}
	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}
	public LocalDateTime getCreationTS() {
		return creationTS;
	}
	public void setCreationTS(LocalDateTime creationTS) {
		this.creationTS = creationTS;
	}
	public LocalDateTime getExpiryTS() {
		return expiryTS;
	}
	public void setExpiryTS(LocalDateTime expiryTS) {
		this.expiryTS = expiryTS;
	}
	@Override
	public String toString() {
		return "URLShortner [longURL=" + longURL + ", shortURL=" + shortURL + ", creationTS=" + creationTS
				+ ", expiryTS=" + expiryTS + "]";
	}
	
	
	

}
