package com.winterlee.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.dojosandninjas.models.Ninja;
import com.winterlee.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	public List<Ninja> getAll() {
		return this.nRepo.findAll();
	}
	
	public Ninja getById(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
}
