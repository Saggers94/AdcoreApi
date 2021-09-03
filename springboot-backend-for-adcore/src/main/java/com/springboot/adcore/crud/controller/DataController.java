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
import com.springboot.adcore.crud.service.DataService;



@CrossOrigin
@RestController
@RequestMapping("/adcore/api/")
public class DataController {
	
	@Autowired
	private DataService ds;
	
	
	@RequestMapping("/feedData")
	public void setDataInDB() {
		ds.saveData();
	}
	
	@Autowired
	private DataRepository dataRepository;
	 
	@GetMapping("/adcore")
	public List<Data> getAllData(){
		return dataRepository.findAll();
	}
	
	@GetMapping("/adcore/{id}")
	public Optional<Data> one(@PathVariable Long id) {
		return dataRepository.findById(id);
	}
}