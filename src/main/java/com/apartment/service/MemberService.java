package com.apartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.model.MemberModel;
import com.apartment.repository.MemberRepository;



@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	public void saveDetails(MemberModel mmodel) {
		memberRepository.save(mmodel);
	}
	
	public MemberModel verifyExist(String hno) {
	return memberRepository.findByHno(hno);
	}
}
