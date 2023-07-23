package com.winterlee.projectmanager.controllers;

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
	
	@GetMapping("show/{projectId}")
	public String showProject(@PathVariable("projectId")Long projectId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("projectToShow", this.pService.getById(projectId));
		
		return "showProject.jsp";
	}
	
	@GetMapping("/edit/{projectId}")
	public String editProject(@PathVariable("projectId")Long projectId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("projectToEdit", this.pService.getById(projectId));
		
		return "editProject.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateProject(@Valid @ModelAttribute("projectToEdit")Project editedProject, BindingResult result, 
			@PathVariable("id")Long projectId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			viewModel.addAttribute("projectToEdit", this.pService.getById(projectId));
			return "editProject.jsp";
		} else {
			editedProject.setCreator(this.uService.findById((Long)session.getAttribute("userId")));
			this.pService.updateProject(editedProject);
			
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/delete/{projectId}")
	public String deleteProject(@PathVariable("projectId")Long projectId, HttpSession session) {
		this.pService.deleteProject(projectId);
		
		return "redirect:/dashboard";
	}
	
}
