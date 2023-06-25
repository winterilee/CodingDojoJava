package com.winterlee.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class OmikujiFormController {
	
	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/show")
	public String omikuji(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="endeavor") String endeavor,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="nice") String nice,
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		
		return "show.jsp";
	}
	
	@GetMapping("/return")
	public String goBack(HttpSession session) {
		session.invalidate();
		return "redirect:/omikuji";
	}
	
}
