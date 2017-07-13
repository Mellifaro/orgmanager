package com.orgmanager.services;

import com.orgmanager.dao.CompanyRepository;
import com.orgmanager.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
