package com.saleh.SpringMvcJpaJBoss.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.saleh.SpringMvcJpaJBoss.Exception.EmployeeNotFoundException;
import com.saleh.SpringMvcJpaJBoss.data.DeptDao;
import com.saleh.SpringMvcJpaJBoss.data.EmpDao;
import com.saleh.SpringMvcJpaJBoss.model.Dept;
import com.saleh.SpringMvcJpaJBoss.model.Emp;

@RestController
@RequestMapping("/rest/emps")
public class EmpRestController {
	
	@Autowired
	EmpDao empDao;
	
	@Autowired
	DeptDao deptDao;
	
    //  http://localhost:8080/SpringMvcJpaJBoss/rest/emps
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Emp> listAllEmps()  
	{
		List<Emp> list =  empDao.findAllOrderedByName();
		return list;
	}
	
    //  http://localhost:8080/SpringMvcJpaJBoss/rest/emps/1
	@RequestMapping(value="/{id}", method = RequestMethod.GET , produces ="application/json" ) 
	public Emp getEmpById(@PathVariable("id") Long id) throws EmployeeNotFoundException
	{
		Emp emp = empDao.findById(id);
		if (emp == null)
		{
			throw new EmployeeNotFoundException(id);
		}
		
		return emp;
	}
	
		//  http://localhost:8080/SpringMvcJpaJBoss/rest/emps/1
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE , produces ="application/json" )
	@ResponseStatus(value= HttpStatus.OK)
	public void deleteEmpById(@PathVariable("id") Long id)
	{
		 empDao.deleteById(id);
		
	}
	
}
