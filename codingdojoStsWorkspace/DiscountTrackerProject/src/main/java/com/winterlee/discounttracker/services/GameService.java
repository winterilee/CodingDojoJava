package com.winterlee.discounttracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.discounttracker.models.Game;
import com.winterlee.discounttracker.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gRepo;
	
	public List<Game> getAll() {
		return this.gRepo.findAll();
	}
	
	public Game getById(Long gameId) {
		return this.gRepo.findById(gameId).orElse(null);
	}
	
	public Game createGame(Game newGame) {
		return this.gRepo.save(newGame);
	}
	
	public Game updateGame(Game editedGame) {
		return this.gRepo.save(editedGame);
	}
	
	public void deleteGame(Long gameId) {
		this.gRepo.deleteById(gameId);
	}
	
	public List<Game> getByPrice(Double selectedPrice) {
		return this.gRepo.findByPriceLessThanEqual(selectedPrice);
	}
}
