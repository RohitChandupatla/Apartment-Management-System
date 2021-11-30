package com.apartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.model.ComplaintModel;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintModel, Integer>{

}
