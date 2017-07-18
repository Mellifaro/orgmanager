package com.orgmanager.services;

import com.orgmanager.dto.CompanyDTO;
import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;

import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
public interface CompanyService {

    Company find(Long id);

    List<CompanyWithChildrenDTO> findAllParentCompanies();

    void delete(Long id);

    void updateFromDto(CompanyDTO companyDTO);
}
