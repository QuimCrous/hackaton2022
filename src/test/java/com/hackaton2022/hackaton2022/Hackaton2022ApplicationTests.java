package com.hackaton2022.hackaton2022;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton2022.hackaton2022.controller.CompanyController;
import com.hackaton2022.hackaton2022.models.Company;
import com.hackaton2022.hackaton2022.services.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class Hackaton2022ApplicationTests {

	@Autowired
	CompanyController companyController;
	@Autowired
	CompanyService companyService;

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	void contextLoads() throws Exception {
		//MvcResult mvcResult = mockMvc.perform(get("/account-holder").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted()).andReturn();
		List<Company> list = companyService.getAllBySize();

		for (Company company: list) {
			System.out.println(company.toString());
		}
	}

}
