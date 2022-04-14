package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    //>>>>> should render on welcome.jsp page;


    @RequestMapping("/list")
    public @ResponseBody List<Company> getList() {
        return companyService.getAllCompanies();
    }
    @RequestMapping("/page")
    public String getPage() {
        return "welcome";
    }
}
