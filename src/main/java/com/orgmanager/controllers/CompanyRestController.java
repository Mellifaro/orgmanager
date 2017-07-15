package com.orgmanager.controllers;

import com.orgmanager.dto.CompanyDTO;
import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;
import com.orgmanager.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Виктор on 15.07.2017.
 */
@RestController
@RequestMapping(value = "/rest/companies")
public class CompanyRestController {

    @Autowired
    private CompanyService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompanyWithChildrenDTO> getAllParents(){
        return service.findAllParentCompanies();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Company getById(@PathVariable("id") int id){
        return service.find(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody CompanyDTO companyDto){
//        service.update(companyDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
//        service.delete(id);
    }
}
