package com.demo.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dsmovie.dto.MovieDTO;
import com.demo.dsmovie.dto.ScoreDTO;
import com.demo.dsmovie.service.MovieService;
import com.demo.dsmovie.service.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;
	
	@PutMapping
	public MovieDTO findById(@RequestBody ScoreDTO scoreDTO) {
		MovieDTO dto = service.saveScore(scoreDTO);
		return dto;
	}
	
}
