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
    public CompanyDTO getById(@PathVariable("id") int id){
        Company company =  service.find(id);
        return new CompanyDTO(company);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void update(CompanyDTO companyDto){
        service.updateFromDto(companyDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
