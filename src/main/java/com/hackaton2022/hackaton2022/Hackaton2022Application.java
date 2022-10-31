package com.hackaton2022.hackaton2022;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton2022.hackaton2022.models.Company;
import com.hackaton2022.hackaton2022.services.CompanyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class Hackaton2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Hackaton2022Application.class, args);
	}

	@Bean
	CommandLineRunner runner(CompanyService companyService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Company>> typeReference = new TypeReference<List<Company>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/companies.json");
			try {
				List<Company> companies = mapper.readValue(inputStream,typeReference);
				companyService.save(companies);
				System.out.println("Companies Saved!");
			} catch (IOException e){
				System.out.println("Unable to save companies: " + e.getMessage());
			}
		};
	}

}
