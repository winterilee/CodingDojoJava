package com.winterlee.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.projectmanager.models.Project;
import com.winterlee.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository pRepo;
	
	public List<Project> getAll() {
		return this.pRepo.findAll();
	}
	
	public Project getById(Long projectId) {
		return this.pRepo.findById(projectId).orElse(null);
	}
	
	public Project createProject(Project newProject) {
		return this.pRepo.save(newProject);
	}
	
	public Project updateProject(Project editedProject) {
		return this.pRepo.save(editedProject);
	}
	
	public void deleteProject(Long projectId) {
		this.pRepo.deleteById(projectId);
	}
	
}
