package com.example.democourierservicemanagementsystem.controllers;

import com.example.democourierservicemanagementsystem.models.Company;
import com.example.democourierservicemanagementsystem.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company); // Save to database, ID should be generated
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
        return companyRepository.findById(id)
                .map(company -> {
                    company.setName(updatedCompany.getName());
                    company.setAddress(updatedCompany.getAddress());
                    company.setContactInfo(updatedCompany.getContactInfo());
                    return companyRepository.save(company);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
        return "Company deleted";
    }
}
