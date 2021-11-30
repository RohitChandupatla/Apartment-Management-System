package com.apartment.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.model.SocietyModel;

public interface SocietyRepository extends JpaRepository<SocietyModel, Integer>{

	public SocietyModel findByUsernameAndPassword(String username,String password);
}
