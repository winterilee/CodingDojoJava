package com.winterlee.burgertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.burgertracker.models.Burger;
import com.winterlee.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	private BurgerRepository bRepo;
	
	public Burger createBurger(Burger newBurger) {
		return this.bRepo.save(newBurger);
	}
	
	public List<Burger> getAll() {
		return this.bRepo.findAll();
	}
	
	public Burger getById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
}
