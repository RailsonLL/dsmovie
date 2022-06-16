package com.demo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
