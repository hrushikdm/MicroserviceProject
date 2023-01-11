package com.hotelmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmicroservice.entity.Hotel;

public interface HotelRepository  extends JpaRepository<Hotel, String>{
}
