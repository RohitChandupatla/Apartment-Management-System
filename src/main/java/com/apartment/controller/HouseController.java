package com.apartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.apartment.model.MemberModel;
import com.apartment.repository.MemberRepository;


@Controller

public class HouseController {

	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/viewhouses")
	public ModelAndView getHouseDetails() {
		ModelAndView mv=new ModelAndView();
		List<MemberModel> mdata=memberRepository.findAll();
		 mv.addObject("mdata",mdata);
		 mv.setViewName("HouseDetails");
		 return mv;
		
	}

	
	@GetMapping("/singlehomedetails")
	public MemberModel getupdate(@RequestParam int id) {
		System.out.println("house control id :"+id);
		return memberRepository.findById(id);
	}
	
	/**PutMapping("/updatedetails")
	public MemberModel updateDetails(@Validated @RequestBody MemberModel mmodel) {
		
		MemberModel mm=memberRepository.findById(mmodel.getId());
		
		mm.setHno(mmodel.getHno());
		
		mm.setSqareyards(mmodel.getSqareyards());
	
		mm.setHdescription(mmodel.getHdescription());
		return memberRepository.save(mm);
	
		
	}**/
	
	@DeleteMapping("/deletehome")
	public void getDeleteModel(@RequestParam int id) {
			 memberRepository.deleteById(id);
				
			}
}
