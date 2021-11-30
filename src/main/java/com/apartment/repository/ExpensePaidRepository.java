package com.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.model.ExpensesPaid;

@Repository
public interface ExpensePaidRepository extends JpaRepository<ExpensesPaid, Integer>{

	public ExpensesPaid findByUsername(String username); 
}
