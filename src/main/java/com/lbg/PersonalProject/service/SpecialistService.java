package com.lbg.PersonalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.PersonalProject.domain.Specialist;
import com.lbg.PersonalProject.repo.SpecialistRepo;

@Service
public class SpecialistService {
	
	private SpecialistRepo repo;
	
	public SpecialistService(SpecialistRepo repo) {
		super();
		this.repo = repo;
	}
	
	public ResponseEntity<Specialist> createSpecialist(Specialist newSpecialist) {
		Specialist created = this.repo.save(newSpecialist);
		
		return new ResponseEntity<Specialist>(created, HttpStatus.CREATED);
	}
	
	public boolean deleteSpecialist(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	public List<Specialist> getSpecialist() {
		return this.repo.findAll();
	}
	
	public ResponseEntity<Specialist> getSpecialist(int id) {
		Optional<Specialist> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Specialist>(HttpStatus.NOT_FOUND);
		}
		
		Specialist body = found.get();
		
		return ResponseEntity.ok(body);
	}
	
	public ResponseEntity<Specialist> updateSpecialist(int id, Specialist newSpecialist) {
		Optional<Specialist> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Specialist>(HttpStatus.NOT_FOUND);
		}		
		Specialist body = found.get();
		if (newSpecialist.getName()!= null)
			body.setName(newSpecialist.getName());
		this.repo.save(body);
		return ResponseEntity.ok(body);
	}

}
