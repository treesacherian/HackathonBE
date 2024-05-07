package com.lbg.PersonalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.PersonalProject.domain.Transaction;
import com.lbg.PersonalProject.repo.TransactionRepo;

@Service
public class TransactionService {

	private TransactionRepo repo;
	
	public TransactionService(TransactionRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ResponseEntity<Transaction> createTransaction(Transaction newTransaction) {
		Transaction created = this.repo.save(newTransaction);
		
		return new ResponseEntity<Transaction>(created, HttpStatus.CREATED);
	}
	
	public boolean deleteTransaction(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	public List<Transaction> getTransaction() {
		return this.repo.findAll();
	}
	
	public ResponseEntity<Transaction> getTransaction(int id) {
		Optional<Transaction> found = this.repo.findById(id);
		
		if (found.isEmpty()) {
			return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
		}
		
		Transaction body = found.get();
		
		return ResponseEntity.ok(body);
	}
	
	
	
}
