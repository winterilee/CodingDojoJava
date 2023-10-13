package com.winterlee.discounttracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winterlee.discounttracker.models.Game;

@Repository
public interface GameRepository  extends CrudRepository<Game, Long>{
	List<Game> findAll();
	List<Game> findByPriceLessThanEqual(Double selectedPrice);
}
