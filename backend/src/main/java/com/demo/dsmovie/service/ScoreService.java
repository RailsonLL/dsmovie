package com.demo.dsmovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dsmovie.dto.MovieDTO;
import com.demo.dsmovie.dto.ScoreDTO;
import com.demo.dsmovie.entities.Movie;
import com.demo.dsmovie.entities.Score;
import com.demo.dsmovie.entities.User;
import com.demo.dsmovie.repositories.MovieRepository;
import com.demo.dsmovie.repositories.ScoreRepository;
import com.demo.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s: movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setCount(movie.getScores().size());
		movie.setScore(avg);
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}
	
}
