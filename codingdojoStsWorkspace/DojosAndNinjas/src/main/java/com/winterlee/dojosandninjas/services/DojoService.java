package com.winterlee.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.dojosandninjas.models.Dojo;
import com.winterlee.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	
	public List<Dojo> getAll() {
		return this.dRepo.findAll();
	}
	
	public Dojo getById(Long Id) {
		return this.dRepo.findById(Id).orElse(null);
	}
	
}
