package com.orgmanager.dto;

import com.orgmanager.models.Company;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Виктор on 15.07.2017.
 */
public class CompanyDTO implements Serializable{
    private static final long serialVersionUID = 4360395719334854364L;

    private Long id;

    @NotNull
    @Length(min = 3, max = 50)
    private String name;

    @NotNull
    private Long earnings;

    private Long parentId;

    public CompanyDTO(){}

    public CompanyDTO(Company company){
        this.id = company.getId();
        this.name = company.getName();
        this.earnings = company.getEarnings();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyDTO)) return false;

        CompanyDTO that = (CompanyDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (earnings != null ? !earnings.equals(that.earnings) : that.earnings != null) return false;
        return parentId != null ? parentId.equals(that.parentId) : that.parentId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (earnings != null ? earnings.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }
}
