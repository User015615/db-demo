package com.database.db_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.database.db_demo.entity.StoreInformation;
import com.database.db_demo.repository.StoreInformationRepository;

import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner {
	
	@Autowired
	StoreInformationRepository storeInformationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}


	public void run(String... args) {
		StoreInformation storeInformationOne = new StoreInformation("Amazon", "Any article can be found here", "07XXXXXXXXX");
		storeInformationRepository.save(storeInformationOne);
		storeInformationRepository.findByStoreName("Amazon").forEach( val -> System.out.println(val) );
	}
}
