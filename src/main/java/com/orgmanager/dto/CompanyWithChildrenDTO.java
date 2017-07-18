package com.orgmanager.dto;

import com.orgmanager.models.Company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 15.07.2017.
 */
//This class is necessary to receive all tree structures with total earnings
public class CompanyWithChildrenDTO implements Serializable{
    private static final long serialVersionUID = 4360395719334854363L;

    private Long id;

    private String name;

    private Long earnings;

    private Long totalEarnings;

    private List<CompanyWithChildrenDTO> listChildCompanies;

    public CompanyWithChildrenDTO(){
    }

    public CompanyWithChildrenDTO(Company company){
        this.id = company.getId();
        this.name = company.getName();
        this.earnings = company.getEarnings();

        //creating a tree of children with total earnings with recursion
        if(company.getListChildCompanies() != null){
            listChildCompanies = new ArrayList<CompanyWithChildrenDTO>();
            company.getListChildCompanies().forEach(comp -> listChildCompanies.add(new CompanyWithChildrenDTO(comp)));
        }

        //counting total earnings for all tree
        if(listChildCompanies == null || listChildCompanies.isEmpty()){
            totalEarnings = earnings;
        }else {
            totalEarnings = earnings;
            listChildCompanies.forEach(comp -> totalEarnings = totalEarnings + comp.totalEarnings);
        }
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

    public Long getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(Long totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public List<CompanyWithChildrenDTO> getListChildCompanies() {
        return listChildCompanies;
    }

    public void setListChildCompanies(List<CompanyWithChildrenDTO> listChildCompanies) {
        this.listChildCompanies = listChildCompanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyWithChildrenDTO)) return false;

        CompanyWithChildrenDTO that = (CompanyWithChildrenDTO) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!earnings.equals(that.earnings)) return false;
        return totalEarnings.equals(that.totalEarnings);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + earnings.hashCode();
        result = 31 * result + totalEarnings.hashCode();
        return result;
    }
}
