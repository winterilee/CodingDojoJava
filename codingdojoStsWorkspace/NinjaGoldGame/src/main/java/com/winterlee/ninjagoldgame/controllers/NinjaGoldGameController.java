package com.winterlee.ninjagoldgame.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class NinjaGoldGameController {

	@GetMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);			
		}
		
		return "index.jsp";
	}
	
	@PostMapping("/farm")
	public String farm(HttpSession session) {
		Random r = new Random();
		int min = 10;
		int max = 20 + 1;
		int rNum = r.nextInt(max-min) + min;
		System.out.println(rNum);
		session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
		
		return "redirect:/";
	}
	@PostMapping("/cave")
	public String cave(HttpSession session) {
		Random r = new Random();
		int min = 5;
		int max = 10 + 1;
		int rNum = r.nextInt(max-min) + min;
		System.out.println(rNum);
		session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);		
		
		return "redirect:/";
	}
	@PostMapping("/house")
	public String house(HttpSession session) {
		Random r = new Random();
		int min = 2;
		int max = 5 + 1;
		int rNum = r.nextInt(max-min) + min;
		System.out.println(rNum);
		session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
		
		return "redirect:/";
	}
	@PostMapping("/quest")
	public String quest(HttpSession session) {
		Random r = new Random();
		int min = -50;
		int max = 50 + 1;
		int rNum = r.nextInt(max-min) + min;
		System.out.println(rNum);
		session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
		
		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
}
