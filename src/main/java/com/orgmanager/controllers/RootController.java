package com.orgmanager.controllers;

import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;
import com.orgmanager.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
@Controller
@RequestMapping("/companies")
public class RootController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCompanies(ModelMap model){
        List<CompanyWithChildrenDTO> companiesList = companyService.findAllParentCompanies();
        model.put("companyList", companiesList);
        return "companies";
    }
}
