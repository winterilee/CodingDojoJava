package com.winterlee.savetravels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SaveTravelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaveTravelsApplication.class, args);
	}
	
	@GetMapping("/")
	public String rootRedirect() {
		return "redirect:/expenses";
	}
	
}
