package com.orgmanager.utils;

import com.orgmanager.dto.CompanyDTO;
import com.orgmanager.models.Company;

/**
 * Created by Виктор on 18.07.2017.
 */
public class CompanyUtils {

    public static Company updateFromDto(Company company, CompanyDTO companyDTO){
        company.setName(companyDTO.getName());
        company.setEarnings(companyDTO.getEarnings());
        return company;
    }
}
