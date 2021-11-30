package com.apartment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.model.ExpensesModel;

public interface ExpensesRepository extends JpaRepository<ExpensesModel, Integer>{

	public ExpensesModel findById(int id);
	
	public List<ExpensesModel> findByHno(String hno);
	public ExpensesModel findByHnoAndId(String hno,int id);
}
