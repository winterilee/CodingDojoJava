package com.winterlee.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.loginandregistration.models.User;
import com.winterlee.loginandregistration.services.UserService;
import com.winterlee.loginandregistration.validators.LoginValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String index(@ModelAttribute("newUser")User newUser, Model viewModel) {
		viewModel.addAttribute("loginUser", new LoginValidator());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model viewModel, HttpSession session) {
        
		User newestUser = this.uService.register(newUser, result);
        if(result.hasErrors()) {
        	viewModel.addAttribute("loginUser", new LoginValidator());
            return "index.jsp";
        }
        
        session.setAttribute("userId", newestUser.getId());
        
        return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginValidator newLogin,
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
		viewModel.addAttribute("currentUser", this.uService.findById((long)session.getAttribute("userId")));
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
