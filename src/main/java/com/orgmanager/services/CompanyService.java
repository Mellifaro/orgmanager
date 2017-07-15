package com.orgmanager.services;

import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;

import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
public interface CompanyService {

    Company find(Integer id);

    List<CompanyWithChildrenDTO> findAllParentCompanies();
}
