package com.usermicroservice.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usermicroservice.entity.User;

public interface UserRespository extends JpaRepository<User, String> {
	// if we want to impl any custom method or query we can create here

//	@Query(value = "SELECT id FROM user WHERE id=userId", nativeQuery = true)
//	public List<User> findById(String userId);
}
