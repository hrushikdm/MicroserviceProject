package com.hotelmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmicroservice.entity.Hotel;
import com.hotelmicroservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
  
	@Autowired
	private HotelService hotelService;
	
	
	//create
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	//get Single hotel
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Hotel>> createHotel(@PathVariable (name = "id") String id)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(id));
	}
	
	
	//get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getAll()
	{
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
	
}
