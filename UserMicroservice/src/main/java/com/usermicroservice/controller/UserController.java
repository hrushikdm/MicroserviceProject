package com.usermicroservice.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usermicroservice.entity.User;
import com.usermicroservice.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	
	@Autowired
	private UserService userService;
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 =userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

	//single user get
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback" )
	public ResponseEntity<User> getSingleUser(@PathVariable (name = "userId") String id)
	{
		User user= userService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	
	
	//rating fall back metheod for circuitbreaker
	
	public ResponseEntity<User> ratingHotelFallback( String userId, Exception ex  )
	{  
		log.info("Fallback is executed because service is down : ", ex.getMessage());
		User u =new User();
		
		log.error("The current user id: "+ userId);
		u.setUserId("43232");
		u.setEmail("dummy@gmail.com");
		u.setName("Dummy");
		u.setAbout("Dummy user is created because some services are down");
		return new ResponseEntity<>(u, HttpStatus.OK);
		
	}
	
	 
	
	
	//all user get
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUser= userService.getAllUser();
		
		return ResponseEntity.ok(allUser);
	}
}
