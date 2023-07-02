package com.winterlee.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.savetravels.models.Expense;
import com.winterlee.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	private ExpenseService eService;
	
	@GetMapping("")
	public String index(@ModelAttribute("expense") Expense expense, Model viewModel) {
		viewModel.addAttribute("expenseList", this.eService.getAll());
		
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("expenseList", this.eService.getAll());
			return "index.jsp";
		} else {
			this.eService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@GetMapping("/edit/{expenseId}")
	public String editExpense(@PathVariable("expenseId") Long expenseId, Model viewModel) {
		viewModel.addAttribute("expenseToEdit", this.eService.getById(expenseId));
		
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateExpense(@Valid @ModelAttribute("expenseToEdit") Expense editedExpense, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.eService.updateExpense(editedExpense);
			return "redirect:/expenses";
		}
	}
	
}
