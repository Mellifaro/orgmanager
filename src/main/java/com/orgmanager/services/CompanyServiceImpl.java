package com.orgmanager.services;

import com.orgmanager.dao.CompanyRepository;
import com.orgmanager.dto.CompanyDTO;
import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;
import com.orgmanager.utils.CompanyUtils;
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

    @Override
    public Company find(Long id) {
        Company company = repository.findOne(id);
        return repository.findOne(id);
    }

    @Override
    public List<CompanyWithChildrenDTO> findAllParentCompanies() {
        List<Company> companyList = repository.findByParentCompany_Id(null);
        List<CompanyWithChildrenDTO> companyWithChildrenDTOs = new ArrayList<>();
        companyList.forEach(comp -> companyWithChildrenDTOs.add(new CompanyWithChildrenDTO(comp)));
        return companyWithChildrenDTOs;
    }

    @Override
    public void updateFromDto(CompanyDTO companyDTO) {
        Company company;
        if(companyDTO.getId() != null){
            company = repository.findOne(companyDTO.getId());
        }else{
            company = new Company();
            if(companyDTO.getParentId() != null){
                company.setParentCompany(repository.findOne(companyDTO.getParentId()));
            }
        }
        company = CompanyUtils.updateFromDto(company, companyDTO);
        repository.save(company);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }
}
