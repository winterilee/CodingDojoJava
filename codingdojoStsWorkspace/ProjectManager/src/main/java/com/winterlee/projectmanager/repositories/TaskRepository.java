package com.winterlee.projectmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winterlee.projectmanager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
}
