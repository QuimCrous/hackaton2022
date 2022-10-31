package com.hackaton2022.hackaton2022.services;

import com.hackaton2022.hackaton2022.models.Company;
import com.hackaton2022.hackaton2022.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> list() {
        return companyRepository.findAll();
    }

    public List<Company> save(List<Company> companies) {
        return companyRepository.saveAll(companies);
    }

    public List<Company> getAllBySize(){
        return companyRepository.findAllBySizeOrdered();
    }

    public List<Company> getCompaniesByFounded() {
        return companyRepository.findAllByOrderByFounded();
    }

    public List<Object[]> countBy(String type){
        switch (type){
            case "industry":
                return companyRepository.countByIndustry();
            case "size":
                return companyRepository.countBySize();
            case "founded":
                return companyRepository.countByFounded();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Request Param missing or wrong.");
        }
    }


}
