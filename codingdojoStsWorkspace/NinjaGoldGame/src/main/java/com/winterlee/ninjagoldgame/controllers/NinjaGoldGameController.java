package com.winterlee.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class NinjaGoldGameController {

	@GetMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		return "index.jsp";
	}
	
	@PostMapping("/action")
	public String action(HttpSession session,
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required=false) String cave,
			@RequestParam(value="house", required=false) String house,
			@RequestParam(value="quest", required=false) String quest) {
		
		ArrayList<String> activities = new ArrayList<String>();
		
		if(farm != null && cave == null && house == null && quest == null) {
			Random r = new Random();
			Date d = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d Y h:mm:ss a");
			int min = 10;
			int max = 20;
			int rNum = r.nextInt(max-(min+1)) + min;
			String cDate = formatter.format(d);
			session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
			String activity = String.format("You entered a farm and earned %s gold. (%s)\n", rNum, cDate);
			if(session.getAttribute("activities") != null) {
				activities = (ArrayList<String>) session.getAttribute("activities");
			}
			activities.add(activity);
			session.setAttribute("activities", activities);
		}
		
		if(farm == null && cave != null && house == null && quest == null) {
			Random r = new Random();
			Date d = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d Y h:mm:ss a");
			int min = 5;
			int max = 10;
			int rNum = r.nextInt(max-(min+1)) + min;
			String cDate = formatter.format(d);
			session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
			String activity = String.format("You entered a cave and earned %s gold. (%s)\n", rNum, cDate);
			if(session.getAttribute("activities") != null) {
				activities = (ArrayList<String>) session.getAttribute("activities");
			}
			activities.add(activity);
			session.setAttribute("activities", activities);
		}
		
		if(farm == null && cave == null && house != null && quest == null) {
			Random r = new Random();
			Date d = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d Y h:mm:ss a");
			int min = 2;
			int max = 5;
			int rNum = r.nextInt(max-(min+1)) + min;
			String cDate = formatter.format(d);
			session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
			String activity = String.format("You entered a house and earned %s gold. (%s)\n", rNum, cDate);
			if(session.getAttribute("activities") != null) {
				activities = (ArrayList<String>) session.getAttribute("activities");
			}
			activities.add(activity);
			session.setAttribute("activities", activities);
		}
		
		if(farm == null && cave == null && house == null && quest != null) {
			Random r = new Random();
			Date d = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("MMMM d Y h:mm:ss a");
			int min = -50;
			int max = 50;
			int rNum = r.nextInt(max-(min+1)) + min;
			String cDate = formatter.format(d);
			session.setAttribute("gold", (Integer) session.getAttribute("gold")+ rNum);
			if(session.getAttribute("activities") != null) {
				activities = (ArrayList<String>) session.getAttribute("activities");
			}
			if(rNum < 0) {
				String activity = String.format("You failed a quest and lost %s gold. (%s)\n", (rNum*-1), cDate);
				activities.add(activity);
			}
			else {
				String activity = String.format("You completed a quest and earned %s gold. (%s)\n", rNum, cDate);
				activities.add(activity);
			}
			session.setAttribute("activities", activities);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
}
