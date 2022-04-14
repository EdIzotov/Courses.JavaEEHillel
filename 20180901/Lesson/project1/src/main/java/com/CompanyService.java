package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    public List getAllCompanies(){
        return companyDAO.getAllCompanies();
    }
}
