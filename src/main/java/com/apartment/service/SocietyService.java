package com.apartment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apartment.model.SocietyModel;
import com.apartment.repository.SocietyRepository;

@Service
public class SocietyService {

	@Autowired
	public SocietyRepository societyRepository;
	
	public SocietyModel submitSociety(SocietyModel smodel) {
		return societyRepository.save(smodel);
	}
	
	public List<SocietyModel> getSocietyDetails(){
		return societyRepository.findAll();
	}
	
}
