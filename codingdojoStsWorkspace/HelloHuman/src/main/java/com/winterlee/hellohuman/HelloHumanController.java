package com.winterlee.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("/")
	public String index(
			@RequestParam(value="fname", required = false) String fname,
			@RequestParam(value="lname", required = false) String lname,
			@RequestParam(value="times", required = false) Integer num) {
		if(fname != null && lname != null && num == null) {
			return String.format("Hello %s %s", fname, lname);			 
		}
		else if(fname != null && lname == null && num != null) {
			String name = String.format("Hello %s ", fname);
			return name.repeat(num);
		}
		else {
			return "Hello Human";
		}
		
	}
	
	
}
