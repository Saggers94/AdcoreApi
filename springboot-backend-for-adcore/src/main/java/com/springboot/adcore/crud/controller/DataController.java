package com.springboot.adcore.crud.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.adcore.crud.model.Data;
import com.springboot.adcore.crud.repository.DataRepository;



@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class DataController {
	@Autowired
	private DataRepository dataRepository;
	 
	@GetMapping("/adcore")
	public List<Data> getAllAstronauts(){
		return dataRepository.findAll();
	}
	
	@GetMapping("/adcore/{id}")
	public Optional<Data> one(@PathVariable Long id) {
		return dataRepository.findById(id);
	}
}