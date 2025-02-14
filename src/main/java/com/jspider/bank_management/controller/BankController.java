package com.jspider.bank_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.bank_management.dao.BankDao;
import com.jspider.bank_management.dto.BankClass;
@CrossOrigin(origins = "*",methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.GET})
@RestController
public class BankController {
	@Autowired
	BankDao dao;
	//done
	//http://localhost:8080/saveUser
	@PostMapping("saveUser")
	public ResponseEntity<BankClass> saveUser(@RequestBody BankClass b)
	{
		return new ResponseEntity<BankClass>(dao.saveUserData(b),HttpStatus.CREATED);
		
	}
	//done
	//fetch account by id
	//http//localhost:8080/fetchBankAccountById?userId="
	@GetMapping("fetchBankAccountById")
	public ResponseEntity<BankClass> fetchBankAccountById(@RequestParam("bankId") int id)
	{
		System.out.println(id);
		BankClass bank=dao.fetchBankUserById(id);
		System.out.println(bank);
		if(bank!=null)
		{
			return new ResponseEntity<BankClass>(bank,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<BankClass>(bank,HttpStatus.NOT_FOUND);
		}
	}
	//done
	//http://localhost:8080/deleteAccount?bankId=5
	@DeleteMapping("/deleteAccount")
	public ResponseEntity<BankClass> deleteAccount(@RequestParam("bankId") int id)
	{
		BankClass bank=dao.deletBankUserById(id);
		if(bank!=null)
		{
			return new ResponseEntity<BankClass>(bank,HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<BankClass>(bank,HttpStatus.NOT_FOUND);
		}
		
		///410
	}
	//done
	//http://localhost:8080/updateBankAccount
	@PutMapping("/updateBankAccount")
	public ResponseEntity<BankClass> updateBankAccount(@RequestBody BankClass e)
	{
		return new ResponseEntity<BankClass>(dao.updateBankUser(e),HttpStatus.ACCEPTED);
	}
	//done
	//http://localhost:8080/fetchAllAccounts
	@GetMapping("/fetchAllAccounts")
	public ResponseEntity<List<BankClass>> fetchAllAccounts()
	{
		List<BankClass> list=dao.fetchAll();
		System.out.println(list);
		if(!list.isEmpty())
		{
			return new ResponseEntity<List<BankClass>>(list, HttpStatus.FOUND);
		}
		else
		{
			return new ResponseEntity<List<BankClass>>(list, HttpStatus.NOT_FOUND);
		}
	}
	//http://localhost:8080/fetchAccountByEmail
	@GetMapping("/fetchAccountByEmail/{userEmail}")
	public List<BankClass> fetchAccountByEmail(@PathVariable("userEmail") String email)
	{
		return dao.findByEmail(email);
	}

}
