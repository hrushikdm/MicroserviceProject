package com.ratingmicroservice.service;

import java.util.List;

import com.ratingmicroservice.entity.Rating;

public interface RatingService {

	//create
	Rating createRating(Rating rating);
	
	
	//get all ratings
	List<Rating> getRatings();
	
	
	//get all by user id
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotel id
	List<Rating>  getRatingByHotelId(String HotelId);
}
