package com.winterlee.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winterlee.projectmanager.models.Project;
import com.winterlee.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List<Project> findAll();
	List<Project> findAllByTeamMembersNotContains(User user);
	List<Project> findAllByTeamMembersContains(User user);
}
