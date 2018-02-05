package com.saleh.SpringMvcJpaJBoss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value={"/company","/home"}) 
public class CompanyController {

// This will be the default for all Http Verbs
//	http://localhost:8080/SpringMvcJpaJBoss/company
@RequestMapping 
public String ForwardToCompanyMainPage (Model model)
{
	return "company";	
}

}
