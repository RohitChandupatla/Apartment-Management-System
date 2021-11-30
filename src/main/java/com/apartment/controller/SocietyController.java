package com.apartment.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apartment.model.SocietyModel;
import com.apartment.service.SocietyService;


@Controller

public class SocietyController {

	@RequestMapping("/addSociety")
	public ModelAndView addSociety() {
		Random r=new Random();
		int h=r.nextInt(1000000-4000)+3000;
		String sid="SID"+h;
		ModelAndView mv=new ModelAndView();
		mv.addObject("sid",sid);
		mv.setViewName("addsociety");
		return mv;
	}
	
	@Autowired
	SocietyService societyService;
	
	@PostMapping("/addsociety")
	public ModelAndView saveSociety(SocietyModel society) {
		
		
		Random r=new Random();
		int h=r.nextInt(1000000-4000)+3000;
		String sid="SID"+h;
		society.setSid(sid);
		//generate password
		
		int pass=r.nextInt(100000);
		String password=""+pass;
		
		//generate username
		String keydata = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		int b=10;
		while (b-- != 0) {
		int character = (int)(Math.random()*keydata.length());
		builder.append(keydata.charAt(character));
		}
	String username=builder.toString();	
		



	society.setUsername(username);

	society.setPassword(password);
	
	




	System.out.println("Owner Login Details...!!!");
	System.out.println("Owner UserName: "+username);
	System.out.println("Owner Password: "+password);
		   
		    ModelAndView mv=new ModelAndView();
		   try {	
			   

			   
			   societyService.submitSociety(society);
		
		 mv.addObject("message","society added successfully..!!!");
		 mv.setViewName("aminhome");
		 
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	return mv;
	}
	
}
