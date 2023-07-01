package com.winterlee.burgertracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.burgertracker.models.Burger;
import com.winterlee.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class BurgerController {
	@Autowired
	private BurgerService bService;
	
	@GetMapping("")
	public String index(@ModelAttribute("burger") Burger burger, Model viewModel) {		
		viewModel.addAttribute("burgerList", this.bService.getAll());
		
		return "index.jsp";
	}
	
	@PostMapping("/new")
	public String newBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("burgerList", this.bService.getAll());
			return "index.jsp";
		} else {
			this.bService.createBurger(burger);
			return "redirect:/";
		}
	}
	
	
}
