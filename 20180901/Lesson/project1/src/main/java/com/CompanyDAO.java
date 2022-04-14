package com;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CompanyDAO {
    public List getAllCompanies() {
        return Arrays.asList(new Company(1, "addr1"), new Company(2, "addr2"));
    }
}
