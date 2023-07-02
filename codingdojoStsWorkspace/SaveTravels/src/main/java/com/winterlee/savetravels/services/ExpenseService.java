package com.winterlee.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.savetravels.models.Expense;
import com.winterlee.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository eRepo;
	
	public Expense createExpense(Expense newExpense) {
		return this.eRepo.save(newExpense);
	}
	
	public List<Expense> getAll() {
		return this.eRepo.findAll();
	}
	
	public Expense getById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	public Expense updateExpense(Expense editedExpense) {
		return this.eRepo.save(editedExpense);
	}
	
}
