package com.jspider.bank_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jspider.bank_management.dto.BankClass;

public interface BankRepository extends JpaRepository<BankClass, Integer>{
	@Query("select a from BankClass a where email=?1")
	List<BankClass> findByEmail(String email);
	

}
