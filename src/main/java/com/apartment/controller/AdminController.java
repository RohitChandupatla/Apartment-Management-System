package com.apartment.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class AdminController {

	@RequestMapping("/admin")
	public String getAdminLogin() {
		return "admin";
	}
	
	@PostMapping("/adminlogin")
	public ModelAndView loginAction(@RequestParam String username,@RequestParam String password) {
		ModelAndView mv=new ModelAndView();
		if(username.equals("Admin")&&password.equals("Admin")) {
			System.out.println("username: "+username);
			System.out.println("password: "+password);
			mv.setViewName("aminhome");
			return mv;
		}
		else {
			mv.addObject("message","Login Failed, check credintials ...!!!");
			mv.setViewName("admin");
			return mv;
		}
	}
	
	
	
}

