package com.demo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
}
