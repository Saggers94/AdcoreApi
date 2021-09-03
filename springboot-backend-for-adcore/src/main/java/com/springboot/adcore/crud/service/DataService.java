package com.springboot.adcore.crud.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.adcore.crud.model.Data;
import com.springboot.adcore.crud.repository.DataRepository;

@Service
public class DataService {

	@Autowired
	private DataRepository dr;
	
	
	String line ="";
	public void saveData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/tree_data.csv"));
			while((line = br.readLine())!=null) {
				String [] data = line.split(",");
				Data d = new Data();
//				d.setName(name);
//				d.setDescription(description);
//				d.setParent(parent)
//				d.isRead_only(read_only);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
