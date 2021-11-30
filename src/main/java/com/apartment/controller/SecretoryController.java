package com.apartment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apartment.model.ExpensesModel;
import com.apartment.model.MemberModel;
import com.apartment.model.SocietyModel;
import com.apartment.repository.ExpensesRepository;
import com.apartment.repository.MemberRepository;
import com.apartment.repository.SocietyRepository;


@Controller

public class SecretoryController {

	@Autowired
	SocietyRepository societyRepository;
	
	@RequestMapping("/secretory")
	public String getSecretoryLogin() {
		return "SecretoryLogin";
	}
	
	@RequestMapping("/secretorylogin")
	public ModelAndView verifyLogin(@RequestParam String username,@RequestParam String password, HttpSession session) {
		ModelAndView model=new ModelAndView();
	
		
		ModelAndView mv=new ModelAndView();
		SocietyModel mm=societyRepository.findByUsernameAndPassword(username,password);
		if(mm!=null) {
		session.setAttribute("id", mm.getId());
		
		session.setAttribute("username", mm.getUsername());
		session.setAttribute("hno", mm.getSocietyhouses());
		mv.setViewName("SecretoryHome");
		return mv;
		}else {
			mv.addObject("message", "Login Failed");
			mv.setViewName("SecretoryLogin");
			return mv;
		}
		
	}
	@Autowired
	MemberRepository memberRepository;
	
	
	@RequestMapping("/addexpenses")
	public ModelAndView addExpenses(HttpSession session) {
		ModelAndView mv=new ModelAndView();
		String hno=(String)session.getAttribute("hno");
		System.out.println("hno:"+hno);
		MemberModel mmodel=memberRepository.findByHno(hno);
		mv.addObject("mydata", mmodel);
		mv.setViewName("AddExpenses");
		return mv;
	}
	
	@Autowired
	ExpensesRepository expensesRepository;
	
	
	@PostMapping("/addexpensesaction")
	public ModelAndView addExpensesAction(ExpensesModel expenses) {
		ModelAndView mav=new ModelAndView();
		
		expenses.getStatus();
		expenses.setStatus("pending");
		
		if(expensesRepository.save(expenses)!=null) {
		
		List<MemberModel> mmodel=memberRepository.findAll();
		mav.addObject("mydata", mmodel);
		mav.addObject("message","Expenses Submitted Successfully..!!");
		mav.setViewName("AddExpenses");
		return mav;
		}else {
			mav.addObject("message","Expenses Submition Failed..!!");
			mav.setViewName("AddExpenses");
			return mav;
		}
	}

	
	
	@GetMapping("/pendinglist")
	public ModelAndView pendingList(HttpSession session) {
		ModelAndView mav=new ModelAndView();
		String hno=(String)session.getAttribute("hno");
		List<ExpensesModel> exp=expensesRepository.findByHno(hno);
		mav.addObject("mydata",exp);
		mav.setViewName("PedingExpensesList");
		return mav;
			
		
	}
}
