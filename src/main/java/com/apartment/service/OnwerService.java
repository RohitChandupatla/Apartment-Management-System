package com.apartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.model.MemberModel;
import com.apartment.repository.MemberRepository;

@Service
public class OnwerService {

	
	@Autowired
	MemberRepository memberRepository;
	
	/**public MemberModel verifyAction(String username,String password) {
		return memberRepository.findByUsernameAndPassword(username, password);
	}**/
	
	public MemberModel getAccount(String username) {
		return memberRepository.findByUsername(username);
	}
	
}
