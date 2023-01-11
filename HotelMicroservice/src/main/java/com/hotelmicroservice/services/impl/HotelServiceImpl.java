package com.hotelmicroservice.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmicroservice.entity.Hotel;
import com.hotelmicroservice.repository.HotelRepository;
import com.hotelmicroservice.services.HotelService;
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto- generated method stub
		String randomId= UUID.randomUUID(). toString();
		hotel.setId(randomId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {

		return hotelRepository.findAll();
	}

	@Override
	public Optional<Hotel> get(String id) {

		return hotelRepository.findById(id);
	}

}
