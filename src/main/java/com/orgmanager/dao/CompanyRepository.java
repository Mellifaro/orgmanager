package com.orgmanager.dao;

import com.orgmanager.models.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
public interface CompanyRepository extends CrudRepository<Company, Long>{

    List<Company> findByParentCompany_Id(Long id);
}
