package com.winterlee.discounttracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.discounttracker.models.User;
import com.winterlee.discounttracker.services.GameService;
import com.winterlee.discounttracker.services.UserService;
import com.winterlee.discounttracker.validators.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private GameService gService;
	
	@GetMapping("")
	public String index(@ModelAttribute("newUser")User newUser, Model viewModel) {
		viewModel.addAttribute("loginUser", new UserValidator());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model viewModel, HttpSession session) {
        
		User newestUser = this.uService.register(newUser, result);
        if(result.hasErrors()) {
        	viewModel.addAttribute("loginUser", new UserValidator());
            return "index.jsp";
        }
        
        session.setAttribute("userId", newestUser.getId());
        
        return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") UserValidator newLogin,
			BindingResult result, Model viewModel, HttpSession session) {
		
		User user = this.uService.login(newLogin, result);
		if(result.hasErrors()) {
			viewModel.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel, HttpSession session) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
		User currentUser = this.uService.getById(currentUserId);
		viewModel.addAttribute("currentUser", currentUser);
		viewModel.addAttribute("allGames", this.gService.getAll());
		viewModel.addAttribute("gamesLessThan10", this.gService.getByPrice(10.00));
		viewModel.addAttribute("gamesLessThan20", this.gService.getByPrice(20.00));
		viewModel.addAttribute("gamesLessThan30", this.gService.getByPrice(30.00));
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
