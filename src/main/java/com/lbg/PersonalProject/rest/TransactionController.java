package com.lbg.PersonalProject.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.PersonalProject.domain.Transaction;
import com.lbg.PersonalProject.service.TransactionService;

@CrossOrigin
@RequestMapping("/transaction")
@RestController
public class TransactionController {
	
	private TransactionService service;
	
	public TransactionController(TransactionService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction newTransaction) {
		return this.service.createTransaction(newTransaction);
	}
	
	@DeleteMapping("delete/{id}")
	public boolean deleteTransaction(@PathVariable int id) {
		return this.service.deleteTransaction(id);
	}
	
	@GetMapping("/get")
	public List<Transaction> getTransaction() {
		return this.service.getTransaction();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable int id) {
		return this.service.getTransaction(id);
	}
}
