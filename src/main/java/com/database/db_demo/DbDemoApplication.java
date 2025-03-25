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
		StoreInformation storeInformationTwo = new StoreInformation("Audible", "Any book can be found here", "06XXXXXXXXX");
		StoreInformation storeInformationThree = new StoreInformation("GoogleResearch", "Any research paper can be found here", "04XXXXXXXXX");
		StoreInformation storeInformationFour = new StoreInformation("Kindle", "Any book can be found here", "03XXXXXXXXX");

		storeInformationRepository.save(storeInformationOne);
		storeInformationRepository.save(storeInformationTwo);
		storeInformationRepository.save(storeInformationThree);
		storeInformationRepository.save(storeInformationFour);
		storeInformationRepository.findByStoreName("Amazon").forEach( val -> System.out.println(val) );
		storeInformationRepository.findByStoreDetail("Any book can be found here").forEach( val -> System.out.println(val) );
		storeInformationRepository.findByStorePhoneNumber("04XXXXXXXXX").forEach( val -> System.out.println(val) );
		storeInformationRepository.findById(54).ifPresent( val -> System.out.println(val) );

		System.out.println(storeInformationRepository.count());
		storeInformationRepository.delete(storeInformationOne);
		System.out.println(storeInformationRepository.count());

	}
}
