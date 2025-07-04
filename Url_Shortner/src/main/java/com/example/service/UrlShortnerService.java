package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface UrlShortnerService {
	
	public String shortenUrl(String longUrl);
	public String getOriginalUrl(String shortKey);
	public String generateShortKey(String input);

}
