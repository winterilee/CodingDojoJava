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

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String index(@ModelAttribute("newUser")User newUser, Model viewModel) {
		viewModel.addAttribute("newUser", new User());
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
       this.uService.register(newUser, result);
        if(result.hasErrors()) {
            return "index.jsp";
        }
        
        return "redirect:/dashboard";
	}
	
}
