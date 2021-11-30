package com.apartment.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.model.MemberModel;

public interface MemberRepository extends JpaRepository<MemberModel, Integer>{

	public MemberModel findById(int id);
	
	public MemberModel findByUsernameAndPassword(String username,String password);
	
	public MemberModel findByUsername(String username);
	
	public MemberModel findByHno(String hno);
	
	public MemberModel findByHnoAndUsername(String hno,String username);
}
