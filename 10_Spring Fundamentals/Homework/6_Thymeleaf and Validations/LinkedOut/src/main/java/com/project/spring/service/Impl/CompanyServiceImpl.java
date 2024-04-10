package com.project.spring.service.Impl;

import com.project.spring.models.dto.CompanyBindingModel;
import com.project.spring.models.entity.Company;
import com.project.spring.repository.CompanyRepository;
import com.project.spring.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public void save(CompanyBindingModel companyBindingModel) {
        Company company = this.modelMapper.map(companyBindingModel, Company.class);
        this.companyRepository.saveAndFlush(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return this.companyRepository.findFirstById(id);
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company company = this.companyRepository.findFirstById(id);
        this.companyRepository.delete(company);
    }

    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }
}
