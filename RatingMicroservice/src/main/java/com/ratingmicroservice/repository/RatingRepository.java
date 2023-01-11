package com.ratingmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingmicroservice.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	//custom Finder methods
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
}
