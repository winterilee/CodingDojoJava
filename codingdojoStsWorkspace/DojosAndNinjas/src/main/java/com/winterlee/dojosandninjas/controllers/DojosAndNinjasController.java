package com.winterlee.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.dojosandninjas.models.Dojo;
import com.winterlee.dojosandninjas.services.DojoService;
import com.winterlee.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class DojosAndNinjasController {
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	
	@GetMapping("")
	public String index() {
		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			return "NewDojo.jsp";
		} else {
			this.dService.createDojo(dojo);
			return "redirect:/";
		}
		
	}
	
	
}
