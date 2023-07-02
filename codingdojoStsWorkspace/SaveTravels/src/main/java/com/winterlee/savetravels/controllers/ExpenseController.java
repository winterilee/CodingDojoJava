package com.winterlee.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.savetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	private ExpenseService eService;
	
	@GetMapping("")
	public String index() {
		
		return "index.jsp";
	}
	
}
