package com.orgmanager.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Виктор on 14.07.2017.
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable{

    private static final long serialVersionUID = 4895237867750981751L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "earnings")
    private Long earnings;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Company parentCompany;

    @OneToMany(mappedBy="parentCompany", fetch = FetchType.EAGER)
    private List<Company> listChildCompanies;

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

    public Company getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(Company parentCompany) {
        this.parentCompany = parentCompany;
    }

    public List<Company> getListChildCompanies() {
        return listChildCompanies;
    }

    public void setListChildCompanies(List<Company> listChildCompanies) {
        this.listChildCompanies = listChildCompanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;

        Company company = (Company) o;

        if (!id.equals(company.id)) return false;
        if (!name.equals(company.name)) return false;
        return earnings.equals(company.earnings);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + earnings.hashCode();
        return result;
    }
}
