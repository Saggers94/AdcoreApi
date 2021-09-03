package com.springboot.adcore.crud.controller;

import java.util.Date;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	 
	@GetMapping("/data")
	public List<Data> getAllData(){
		return (List<Data>) dataRepository.findAll();
	}
	
	@GetMapping("/data/{id}")
	public Optional<Data> one(@PathVariable Long id) {
		return dataRepository.findById(id);
	}
	
	@PostMapping(path="/add",consumes={"application/json"})
	public Data saveData(@RequestBody Data data) {
		Data addedData = dataRepository.save(data);
		return addedData;
	}
	
	@PutMapping(path="/update/{id}", consumes= {"application/json"})
	public Data updateData(@PathVariable Long id, @RequestBody Data newData) {

		
		if (dataRepository.findById(id).isPresent()){
            Data existingData = dataRepository.findById(id).get();
            Date date = new Date();
            
			 existingData.setName(newData.getName());
			 existingData.setDescription(newData.getDescription());
			 existingData.setParent(newData.getParent());
			 existingData.setRead_only(newData.getRead_only());
			 existingData.setCreated(date);
			 existingData.setUpdated(date);

            Data updatedData = dataRepository.save(existingData);
            return updatedData;

        }else{
            return null;
        }
				
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		dataRepository.deleteById(id);
	}
	
}