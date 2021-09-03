package com.springboot.adcore.crud;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.springboot.adcore.crud.model.Data;
import com.springboot.adcore.crud.repository.DataRepository;


@SpringBootApplication
public class SpringbootBackendForAdcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendForAdcoreApplication.class, args);
	}

}


@Component
class DemoCommandLineRunner implements CommandLineRunner{

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	Date date = new Date(); 
	long nextId = 0L;
	
	@Autowired
	private DataRepository dataRepository;
	

	@Override
	public void run(String... args) throws Exception {	
		Data oneD = new Data("Node","node description",0,false,date,date);
	}
}