package com.winterlee.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.projectmanager.models.Task;
import com.winterlee.projectmanager.services.ProjectService;
import com.winterlee.projectmanager.services.TaskService;
import com.winterlee.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private UserService uService;
	@Autowired
	private ProjectService pService;
	@Autowired
	private TaskService tService;
	
	@GetMapping("/{projectId}")
	public String showTasks(@ModelAttribute("newTask")Task newTask, HttpSession session, @PathVariable("projectId")Long projectId, Model viewModel) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("selectedProject", this.pService.getById(projectId));
		
		return "showTasks.jsp";
	}
	
	@PostMapping("/{projectId}/create")
	public String createTask(@Valid @ModelAttribute("newTask")Task newTask, BindingResult result, HttpSession session, @PathVariable("projectId")Long projectId, Model viewModel) {
		Long currentUserId = (Long) session.getAttribute("userId");
		if (currentUserId == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			viewModel.addAttribute("selectedProject", this.pService.getById(projectId));
			
			return "showTasks.jsp";
		}
		
		viewModel.addAttribute("selectedProject", this.pService.getById(projectId));
		
		newTask.setCreatorForTask(this.uService.findById(currentUserId));
		newTask.setProjectForTask(this.pService.getById(projectId));
		this.tService.createTask(newTask);
		
		return "redirect:/tasks/"+projectId;
	}
	
	
}
