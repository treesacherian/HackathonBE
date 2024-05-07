package com.lbg.PersonalProject.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.PersonalProject.domain.Specialist;
import com.lbg.PersonalProject.service.SpecialistService;

@CrossOrigin
@RequestMapping("/specialist")
@RestController
public class SpecialistController {
	
	private SpecialistService service;
	
	public SpecialistController(SpecialistService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Specialist> createSpecialist(@RequestBody Specialist newSpecialist) {

		return this.service.createSpecialist(newSpecialist);
	}

	@DeleteMapping("delete/{id}")
	public boolean deleteSpecialist(@PathVariable int id) {
		return this.service.deleteSpecialist(id);
	}
	
	@GetMapping("/get")
	public List<Specialist> getSpecialist() {
		return this.service.getSpecialist();
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Specialist> getSpecialist(@PathVariable int id) {
		return this.service.getSpecialist(id);
	}
	
	@PatchMapping("/update/{id}")
	public ResponseEntity<Specialist> updateSpecialist(@PathVariable int id, @RequestBody Specialist newSpecialist) {

		return this.service.updateSpecialist(id, newSpecialist);

	}

}
