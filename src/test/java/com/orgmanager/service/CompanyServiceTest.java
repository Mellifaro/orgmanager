package com.orgmanager.service;

import com.orgmanager.config.DaoAppConfig;
import com.orgmanager.config.ServicesAppConfig;
import com.orgmanager.dto.CompanyWithChildrenDTO;
import com.orgmanager.models.Company;
import com.orgmanager.services.CompanyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DaoAppConfig.class, ServicesAppConfig.class})
@Sql(scripts = "classpath:db/populateDB.sql",
        config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("local")
public class CompanyServiceTest {

    @Autowired
    protected CompanyService service;

    @Test
    public void testGet(){
        Company found = service.find(100L);
        Assert.assertNotNull(found);
    }

    @Test
    public void testGetAllParents(){
        List<CompanyWithChildrenDTO> companyList = service.findAllParentCompanies();
        Assert.assertEquals(3, companyList.size());
    }
}
