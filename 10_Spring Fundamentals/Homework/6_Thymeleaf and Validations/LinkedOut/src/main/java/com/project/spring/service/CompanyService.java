package com.project.spring.service;

import com.project.spring.models.dto.CompanyBindingModel;
import com.project.spring.models.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies ();
    void save(CompanyBindingModel companyBindingModel);
    Company getCompanyById(Long id);
    void deleteCompanyById(Long id);
}
