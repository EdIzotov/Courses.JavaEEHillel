package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CompanyController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resources/spring-application.xml");
        CompanyService service = applicationContext.getBean("companyService", CompanyService.class);
        List allCompanies = service.getAllCompanies();
        assert allCompanies.size() == 2 : "all companies list size should be > 0";
    }
}
