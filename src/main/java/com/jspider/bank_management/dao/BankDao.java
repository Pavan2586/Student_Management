package com.jspider.bank_management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jspider.bank_management.dto.BankClass;
import com.jspider.bank_management.repository.BankRepository;


@Repository
public class BankDao {
	@Autowired
	BankRepository repositoy;
	public BankClass saveUserData(BankClass bank)
	{
		return repositoy.save(bank);
		
	}
	public BankClass fetchBankUserById(int id)
	{
		Optional<BankClass> op=repositoy.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
		
	}
	public BankClass deletBankUserById(int id)
	{
		Optional<BankClass> op=repositoy.findById(id);
		if(op.isPresent())
		{
			BankClass bank=op.get();
			repositoy.delete(bank);
			return bank;
		}
		else
		{
			return null;
		}
		
	}
	public BankClass updateBankUser(BankClass bank)
	{
		Optional<BankClass> op=repositoy.findById(bank.getId());
		if(op.isPresent())
		{
			return repositoy.save(bank);
		}
		else
		{
			return null;
			
		}
	}
	public List<BankClass> fetchAll()
	{
		return repositoy.findAll();
	}
	
	public List<BankClass> findByEmail(String email)
	{
		return repositoy.findByEmail(email);
	}
}
