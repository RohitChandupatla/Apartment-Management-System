package com.apartment.controller;

import java.util.List;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apartment.model.MemberModel;
import com.apartment.model.SocietyModel;
import com.apartment.service.MemberService;
import com.apartment.service.SocietyService;


@Controller

public class MembersController {

	
@Autowired
SocietyService societyService;
	
@Autowired
MemberService memberService;


@GetMapping("/getsociety")	
public List<SocietyModel> getSocietyDetails() {
	return societyService.getSocietyDetails();
	
}

@RequestMapping("/addmembers")
public ModelAndView addmember() {
	ModelAndView mv=new ModelAndView();
	List<SocietyModel> slist=societyService.getSocietyDetails();
	mv.addObject("sdata", slist);
	mv.setViewName("addmember");
	return mv;
}


@PostMapping("/addmemberdetails")
public ModelAndView saveDetails(MemberModel mmodel) {
	
	//generate password
	Random r=new Random();
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
	



mmodel.setUsername(username);

mmodel.setPassword(password);
String hno=mmodel.getHno();

String email=mmodel.getEmail();

System.out.println(email);

String msg="Hello Member your \nUserName: "+username+"\npassword: "+password+"\nAllocated Hno:"+hno;



System.out.println("User Login Details...!!!");
System.out.println("UserName: "+username);
System.out.println("Password: "+password);

ModelAndView mv=new ModelAndView();
if(memberService.verifyExist(mmodel.getHno())!=null) {

	 
	

	   mv.addObject("message","society added successfully..!!!");
		 mv.setViewName("aminhome");
	 return mv;
		
}else {

   memberService.saveDetails(mmodel);

   mv.addObject("message","society added successfully..!!!");
	 mv.setViewName("aminhome");
 return mv;
	
}
}

}
