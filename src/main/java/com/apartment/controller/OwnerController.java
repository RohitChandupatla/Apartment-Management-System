package com.apartment.controller;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apartment.model.ComplaintModel;
import com.apartment.model.ExpensesModel;

import com.apartment.model.MemberModel;
import com.apartment.repository.ComplaintRepository;

import com.apartment.repository.ExpensesRepository;
import com.apartment.repository.MemberRepository;
import com.apartment.service.OnwerService;


@Controller

public class OwnerController {

	@RequestMapping("/member")
	public String getOwnerLogin() {
		return "OwnerLogin";
	}
	
	@Autowired
	OnwerService onwerService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	@PostMapping("/ownerlogin")
	public ModelAndView ownerLoginAction(@RequestParam String username,@RequestParam String password,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		MemberModel mm=memberRepository.findByUsernameAndPassword(username,password);
		if(mm!=null) {
		session.setAttribute("uid", mm.getId());
		session.setAttribute("uname", mm.getName());
		session.setAttribute("username", mm.getUsername());
		session.setAttribute("hno", mm.getHno());
		session.setAttribute("sid", mm.getSid());
		mv.setViewName("OwnerHome");
		return mv;
		}else {
			mv.addObject("message", "Login Failed");
			mv.setViewName("OwnerHome");
			return mv;
		}
	}
	
	
	@RequestMapping("/viewowneraccount")
	public ModelAndView viewAccount(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		String username=(String)session.getAttribute("username");
		
		MemberModel member=onwerService.getAccount(username);
		
		mv.addObject("mydata",member);
		mv.setViewName("OwnerMyAccount");
		return mv;
	}
	
	@RequestMapping("/updateowner")
	public ModelAndView updateAccount(@RequestParam String username) {
		ModelAndView mv=new ModelAndView();
		MemberModel member=onwerService.getAccount(username);
		
		mv.addObject("mydata",member);
		mv.setViewName("UpdateOwnerAccount");
		
		
		return mv;
	}
	
	@RequestMapping("/updateownerdetails")
	public ModelAndView updateAction(@ModelAttribute MemberModel mm) {
		ModelAndView vi=new ModelAndView();
		
		MemberModel member=memberRepository.findByUsername(mm.getUsername());
		
		member.getName();
		member.setName(mm.getName());
		member.getEmail();
		member.setEmail(mm.getEmail());
		member.getMobile();
		member.setMobile(mm.getMobile());
		
		memberRepository.save(member);
		
		MemberModel member1=onwerService.getAccount(mm.getUsername());
		
		vi.addObject("mydata",member1);
		vi.setViewName("OwnerMyAccount");
		return vi;
	}
	
	@RequestMapping("/addcomplaint")
	public ModelAndView getHno(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		String username=(String)session.getAttribute("username");
		MemberModel member=memberRepository.findByUsername(username);
		
		mv.addObject("mydata", member.getHno());
		mv.setViewName("OwnerComplaint");
		return mv;
	}
	
	
	
	
	@PostMapping("/ownercomplaint")
	public ModelAndView ownerComplaint(ComplaintModel cmodel) {
		ModelAndView mv=new ModelAndView();
		Date d=new Date();
		String dd=""+d;
		cmodel.getDate();
		cmodel.setDate(dd);
		
		 if(complaintRepository.save(cmodel)!=null) {
		
		mv.addObject("message","Complaint Submitted Successfully....!!!");
		mv.setViewName("OwnerComplaint");	
		return mv;
		 }else {
			 mv.addObject("message","Complaint Submiting Failed....!!!");
				mv.setViewName("OwnerComplaint");	
				return mv;
		 }
	}
	@Autowired
	ExpensesRepository expensesRepository;
	

	
	@RequestMapping("/ownerviewevents")
	public ModelAndView viewExpensesAndEvents(HttpSession session) {
		ModelAndView model=new ModelAndView();
		String hno=(String)session.getAttribute("hno");
		String username=(String)session.getAttribute("username");
		
		System.out.println("hno: "+hno);
		System.out.println("username: "+username);
		
		MemberModel member=memberRepository.findByHnoAndUsername(hno,username);
		
		model.addObject("hno", member.getHno());
		
		List<ExpensesModel> emodel=expensesRepository.findByHno(hno);
		
	
		model.addObject("expdata",emodel);
		model.setViewName("OwnerViewExpenses");
		return model;
	}

	//option handler
	@GetMapping("/getExpenses")
	public List<ExpensesModel> getExpenses(){
		return expensesRepository.findAll();
	}
	
	@GetMapping("/getExpensesByHno")
	public List<ExpensesModel> getExpByUser(@RequestParam String hno) {
		return expensesRepository.findByHno(hno);
	}
	
	@GetMapping("/payexpenses")
	public ModelAndView payExpStatus(@RequestParam int id) {
		ModelAndView mv=new ModelAndView();
		System.out.println("expected Id is: "+id);
		
		ExpensesModel exmodel=expensesRepository.findById(id);
		exmodel.getStatus();
		exmodel.setStatus("Paid");
		
		ExpensesModel cmo=expensesRepository.save(exmodel);
		if(cmo!=null) {
			mv.addObject("expdata", cmo);
			mv.setViewName("OwnerViewExpenses");
			 return mv;
		}else {
			mv.addObject("message","paying failed..!!");
			mv.setViewName("OwnerViewExpenses");	
			return mv;
		}
		
		
	}
}
