package com.hotelmicroservice.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.hotelmicroservice.entity.Hotel;


public interface HotelService {

	// create
	Hotel create(Hotel hotel);

	// get
	List<Hotel> getAllHotels();

	// get Single

	Optional<Hotel> get(String id);

}
