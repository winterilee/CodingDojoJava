package com.winterlee.projectmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.projectmanager.models.Project;
import com.winterlee.projectmanager.models.User;
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
	
	public void joinTeam(Project projectToJoin, User userToJoin) {
		projectToJoin.getTeamMembers().add(userToJoin);
		this.pRepo.save(projectToJoin);
	}
	
	public void unjoinTeam(Project projectToUnjoin, User userToUnjoin) {
		projectToUnjoin.getTeamMembers().remove(userToUnjoin);
		this.pRepo.save(projectToUnjoin);
	}
	
	public List<Project> getAllWithoutMember(User user) {
		return this.pRepo.findAllByTeamMembersNotContains(user);
	}
	
	public List<Project> getAllWithMember(User user) {
		return this.pRepo.findAllByTeamMembersContains(user);
	}
	
}
