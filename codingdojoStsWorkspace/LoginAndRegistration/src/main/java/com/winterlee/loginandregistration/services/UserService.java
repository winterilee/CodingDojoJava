package com.winterlee.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.winterlee.loginandregistration.models.User;
import com.winterlee.loginandregistration.repositories.UserRepository;
import com.winterlee.loginandregistration.validators.LoginValidator;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User register(User newUser, BindingResult result) {
		
		Optional<User> potentialUser = this.uRepo.findByEmail(newUser.getEmail());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Please enter a valid email.");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords must match.");
		}
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return this.uRepo.save(newUser);
	}
	
	public User findById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	public User login(LoginValidator newLoginObject, BindingResult result) {
		
		Optional<User> potentialUser = this.uRepo.findByEmail(newLoginObject.getEmail());
		
		if(potentialUser.isPresent()) {
			User user = potentialUser.get();
			if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("email", "Matches", "Invalid Credentials.");
			}
			return user;
		} else {
			result.rejectValue("email", "Matches", "Invalid Credentials.");
			return null;
		}
	}
	
}
