package com.winterlee.discounttracker.controllers;

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

import com.winterlee.discounttracker.models.Game;
import com.winterlee.discounttracker.services.GameService;
import com.winterlee.discounttracker.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/games")
public class GameController {
	@Autowired
	private UserService uService;
	@Autowired
	private GameService gService;
	
	@GetMapping("/new")
	public String newGame(@ModelAttribute("newGame")Game newGame, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "newGame.jsp";
	}
	
	@PostMapping("/create")
	public String createGame(@Valid @ModelAttribute("newGame")Game newGame, BindingResult result, HttpSession session) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			return "newGame.jsp";
		}
		
		newGame.setCreator(this.uService.getById(currentUserId));
		this.gService.createGame(newGame);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/show/{gameId}")
	public String showGame(@PathVariable("gameId")Long gameId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("gameToShow", this.gService.getById(gameId));
		
		return "showGame.jsp";
	}
	
	@GetMapping("/edit/{gameId}")
	public String editGame(@PathVariable("gameId")Long gameId, Model viewModel, HttpSession session) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
		
		if (!this.gService.getById(gameId).getCreator().getId().equals(currentUserId)) {
			return "redirect:/dashboard";
		}
		
		viewModel.addAttribute("gameToEdit", this.gService.getById(gameId));
		
		return "editGame.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateGame(@Valid @ModelAttribute("gameToEdit")Game editedGame, BindingResult result, 
			@PathVariable("id")Long gameId, Model viewModel, HttpSession session) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
		
		if (!this.gService.getById(gameId).getCreator().getId().equals(currentUserId)) {
			return "redirect:/dashboard";
		}
		
		if (result.hasErrors()) {
			viewModel.addAttribute("gameToEdit", editedGame);
			return "editGame.jsp";
		} else {
			editedGame.setCreator(this.uService.getById(currentUserId));
			this.gService.updateGame(editedGame);
			
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/delete/{gameId}")
	public String deleteGame(@PathVariable("gameId")Long gameId, HttpSession session) {
		this.gService.deleteGame(gameId);
		
		return "redirect:/dashboard";
	}
	
	
}