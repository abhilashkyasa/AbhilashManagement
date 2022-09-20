package com.example.AbhilashManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AbhilashManagement.entity.DocEntity;
import com.example.AbhilashManagement.service.DocService;

@RestController
public class DocController {
	

	    @Autowired
	    private DocService service;
	    
	    @PostMapping("/Doctor")
	    public String addDoctor(@RequestBody DocEntity Doctor) {
	        return service.addDoctor(Doctor);}

	    @PutMapping("/Doctor/{id}/{salary}")
	    public DocEntity updateDoctor(@PathVariable int salary, @PathVariable int id, @RequestBody DocEntity Doctor) {
	        return service.updateDoctor(Doctor, salary);
	    }

	    @GetMapping("/Doctor")
	    public List<DocEntity> getAllDoctor(){
	        return service.getDoctor();
	    }
	    
	    @ExceptionHandler(value = com.example.AbhilashManagement.exception.DocExist.class)
		public ResponseEntity<String> DocExist(
				com.example.AbhilashManagement.exception.DocExist ExistExp) {
			return new ResponseEntity<String>("Doctor Id already exists!",HttpStatus.CONFLICT);

	    }
	}