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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
    @NotBlank(message="First name is required.")
	@Size(min=2, max=45, message="First name must be at least 2 characters.")
	private String firstName;
	
	@NotBlank(message="Last name is required.")
	@Size(min=2, max=45, message="Last name must be at least 2 characters.")
	private String lastName;
	
	@NotBlank(message="Email is required.")
	@Email(message="Please enter a valid email.")
	private String email;
	
	@NotBlank(message="Password is required.")
    @Size(min=8, message="Password must be at least 8 characters.")
    private String password;
    
    @Transient
    @NotBlank(message="Confirm Password is required.")
    @Size(min=8, message="Confirm Password must be at least 8 characters.")
    private String confirm;
	
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
	private List<Project> myProjects;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name = "teams",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="project_id")
	)
	private List<Project> teamProjects;
	
	@OneToMany(mappedBy="creatorForTask", fetch=FetchType.LAZY)
	private List<Task> createdTasks;
	
	public User() {}
	
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public List<Project> getMyProjects() {
		return myProjects;
	}
	public void setMyProjects(List<Project> myProjects) {
		this.myProjects = myProjects;
	}
	public List<Project> getTeamProjects() {
		return teamProjects;
	}
	public void setTeamProjects(List<Project> teamProjects) {
		this.teamProjects = teamProjects;
	}
	public List<Task> getCreatedTasks() {
		return createdTasks;
	}
	public void setCreatedTasks(List<Task> createdTasks) {
		this.createdTasks = createdTasks;
	}
	
}
