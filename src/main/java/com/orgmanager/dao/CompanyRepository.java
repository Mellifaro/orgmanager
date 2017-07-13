package com.orgmanager.dao;

import com.orgmanager.models.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Виктор on 14.07.2017.
 */
public interface CompanyRepository extends CrudRepository<Company, Integer>{
}
