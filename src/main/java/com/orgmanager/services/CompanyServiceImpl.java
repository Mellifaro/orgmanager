package com.orgmanager.services;

import com.orgmanager.dao.CompanyRepository;
import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository repository;

    public Company find(Integer id) {
        return repository.findOne(id);
    }

    public List<CompanyWithChildrenDTO> findAllParentCompanies() {
        List<Company> companyList = repository.findByParentCompany_Id(null);
        List<CompanyWithChildrenDTO> companyWithChildrenDTOs = new ArrayList<>();
        companyList.forEach(comp -> companyWithChildrenDTOs.add(new CompanyWithChildrenDTO(comp)));
        return companyWithChildrenDTOs;
    }
}
