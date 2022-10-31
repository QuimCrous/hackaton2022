package com.hackaton2022.hackaton2022.controller;

import com.hackaton2022.hackaton2022.models.Company;
import com.hackaton2022.hackaton2022.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/all-companies")
    public List<Company> list() {
        return companyService.list();
    }

    @GetMapping("/by-size")
    public List<Company> getAllBySize(){
        return companyService.getAllBySize();
    }

    @GetMapping("/get-companies-by-founded")
    public List<Company> getCompaniesByFounded(){
        return companyService.getCompaniesByFounded();
    }

    @GetMapping("/count-by")
    public List<Object[]> countBy(@RequestParam String type){
        return companyService.countBy(type);
    }
}
