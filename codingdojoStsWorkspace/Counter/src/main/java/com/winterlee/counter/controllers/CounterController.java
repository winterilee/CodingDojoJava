package com.winterlee.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class CounterController {
	
	@GetMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		}
		
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String count(HttpSession session) {
		return "counter.jsp";
	}
	
	@PostMapping("/increment")
	public String increment(HttpSession session) {
		session.setAttribute("count", (Integer) session.getAttribute("count") + 2);
		return "redirect:/counter";
	}
	
	@PostMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
