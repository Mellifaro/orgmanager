package com.orgmanager.dto;

import com.orgmanager.models.Company;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;

/**
 * Created by Виктор on 15.07.2017.
 */
public class CompanyDTO {

    private Integer id;

    @NotEmpty
    private String name;

    private Long earnings;

    private Integer parentId;

    public CompanyDTO(){}

    public CompanyDTO(Company company){
        this.id = company.getId();
        this.name = company.getName();
        this.earnings = company.getEarnings();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEarnings() {
        return earnings;
    }

    public void setEarnings(Long earnings) {
        this.earnings = earnings;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyDTO)) return false;

        CompanyDTO that = (CompanyDTO) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!earnings.equals(that.earnings)) return false;
        return parentId.equals(that.parentId);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + earnings.hashCode();
        result = 31 * result + parentId.hashCode();
        return result;
    }
}
