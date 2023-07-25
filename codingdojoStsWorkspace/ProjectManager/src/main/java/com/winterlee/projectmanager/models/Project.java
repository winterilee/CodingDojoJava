package com.winterlee.projectmanager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@NotEmpty(message="Title is required.")
	@Size(min=3, max=255, message="Title must be at least 3 characters.")
	private String title;
	@NotEmpty(message="Description is required.")
	@Size(min=3, message="Description must be at least 3 characters.")
	private String description;
	@NotNull(message="Due Date is required.")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	@Future(message="Due Date must be a future date.")
	private Date dueDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="creator_id")
	private User creator;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "teams",
			joinColumns = @JoinColumn(name="project_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> teamMembers;
	
	@OneToMany(mappedBy="projectForTask", fetch=FetchType.LAZY)
	private List<Task> projectTasks;
	
	public Project() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public List<User> getTeamMembers() {
		return teamMembers;
	}
	public void setTeamMembers(List<User> teamMembers) {
		this.teamMembers = teamMembers;
	}
	public List<Task> getProjectTasks() {
		return projectTasks;
	}
	public void setProjectTasks(List<Task> projectTasks) {
		this.projectTasks = projectTasks;
	}
	
}
