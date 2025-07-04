package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.URLShortner;

@Repository
public interface URLShortnerRepository extends JpaRepository<URLShortner,Integer> {

	
	@Query(value ="select * from url_shortner where shortUrl = ?1",nativeQuery=true)
	List<URLShortner> findByShortUrl(String url);
}
