package com.example.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cache.UrlCache;
import com.example.entity.URLShortner;
import com.example.repository.URLShortnerRepository;
import com.example.service.UrlShortnerService;


public class UrlShortnerServiceImpl implements UrlShortnerService {
	
	@Autowired
	private URLShortnerRepository repository;
	
	@Autowired
	private UrlCache cache;

	@Override
	public String shortenUrl(String longUrl) {
	
		String shortUrl = generateShortKey(longUrl);
		URLShortner urlShortner = new URLShortner(longUrl,shortUrl,LocalDate.now().plusYears(5).atStartOfDay());
		repository.save(urlShortner);
		cache.put(shortUrl,longUrl);
		return shortUrl;
	}

	@Override
	public String getOriginalUrl(String shortKey) {
		String longUrl = cache.get(shortKey);
		if(longUrl == null) {
		 longUrl = repository.findByShortUrl(shortKey).stream().map(URLShortner:: getLongURL).findFirst().get();
		}
		return longUrl;
	}

	@Override
	public String generateShortKey(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
