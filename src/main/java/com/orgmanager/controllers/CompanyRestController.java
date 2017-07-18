package com.orgmanager.controllers;

import com.orgmanager.dto.CompanyDTO;
import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;
import com.orgmanager.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    public CompanyDTO getById(@PathVariable("id") Long id){
        Company company =  service.find(id);
        return new CompanyDTO(company);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> update(@Valid CompanyDTO companyDto, BindingResult result){
        if(result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }else {
            service.updateFromDto(companyDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
