package com.winterlee.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.projectmanager.models.Project;
import com.winterlee.projectmanager.services.ProjectService;
import com.winterlee.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectService pService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/new")
	public String newProject(@ModelAttribute("newProject")Project newProject, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		return "newProject.jsp";
	}
	
	@PostMapping("/create")
	public String createProject(@Valid @ModelAttribute("newProject")Project newProject, BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			return "newProject.jsp";
		}
		
		newProject.setCreator(this.uService.findById((Long)session.getAttribute("userId")));
		this.pService.createProject(newProject);
		
		return "redirect:/dashboard";
	}
	
}
