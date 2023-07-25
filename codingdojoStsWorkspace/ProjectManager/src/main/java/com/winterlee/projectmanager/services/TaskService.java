package com.winterlee.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.projectmanager.models.Task;
import com.winterlee.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository tRepo;
	
	public Task createTask(Task newTask) {
		return this.tRepo.save(newTask);
	}
	
}
