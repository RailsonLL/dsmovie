package com.demo.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.dsmovie.entities.Score;
import com.demo.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
