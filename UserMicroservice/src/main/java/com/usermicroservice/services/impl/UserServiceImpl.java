package com.usermicroservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usermicroservice.entity.Hotel;
import com.usermicroservice.entity.Rating;
import com.usermicroservice.entity.User;
import com.usermicroservice.exceptions.ResourceNotFoundException;
import com.usermicroservice.external.services.HotelService;
import com.usermicroservice.repositories.UserRespository;
import com.usermicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;

	public User saveUser(User user) {

		String randumUserId = UUID.randomUUID().toString();
		user.setUserId(randumUserId);
		return userRespository.save(user);
	}

	public List<User> getAllUser() {
		return userRespository.findAll();
	}

	public User getUser(String userId) {
		User user = userRespository.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
		// fetch rating of the above users from rating service using rest template
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RatingService/ratings/users/" + userId,
				Rating[].class);
		logger.info("{ } ", user);

		List<Rating> ratings = Arrays.asList(ratingsOfUser);

		List<Rating> ratingList = ratings.stream().map(rating -> {

			String id = rating.getHotelId();
			// api call to hotel service to get the hotel

			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
		//	Hotel hotel=forEntity.getBody();
			
			//implemented fiegn client
			Hotel hotel =hotelService.getHotel(rating.getHotelId()); 
			
			//set hotel to rating
			
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}
}
