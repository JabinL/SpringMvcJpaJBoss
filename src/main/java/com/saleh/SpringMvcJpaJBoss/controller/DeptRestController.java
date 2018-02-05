package com.saleh.SpringMvcJpaJBoss.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.saleh.SpringMvcJpaJBoss.Exception.DepartmentNotFoundException;
import com.saleh.SpringMvcJpaJBoss.data.DeptDao;
import com.saleh.SpringMvcJpaJBoss.data.EmpDao;
import com.saleh.SpringMvcJpaJBoss.model.Dept;
import com.saleh.SpringMvcJpaJBoss.model.Emp;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/rest/depts")
public class DeptRestController { 
	
	@Autowired
	DeptDao deptDao;
	
	@Autowired
	EmpDao empDao;
	
	//  http://localhost:8080/SpringMvcJpaJBoss/rest/depts/
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value=HttpStatus.OK) // optional
	public List<Dept> listAllDepts()  
	{
		List<Dept> list =  deptDao.findAllOrderedByName();
		return list;
	}

	
	//  http://localhost:8080/SpringMvcJpaJBoss/rest/depts/1
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
	public Dept getDeptById(@PathVariable("id") Long id) throws DepartmentNotFoundException
	{
		Dept dept = deptDao.findById(id);
		if (dept == null)
		{
			 throw new DepartmentNotFoundException(id);
		}
		return dept;
	}
	
	// http://localhost:8080/SpringMvcJpaJBoss/rest/depts/1/emps
	@RequestMapping(value="/{id}/emps", method= RequestMethod.GET, produces = "application/json")
	public List<Emp> listEmpsByDept(@PathVariable("id") Long deptId)
	{
		Dept dept = deptDao.findById(deptId);
		if (dept == null)
		{
			 throw new DepartmentNotFoundException(deptId);
		}
		List<Emp> emps = dept.getEmps();
		return emps;
	}
	
	// verb= POST http://localhost:8080/SpringMvcJpaJBoss/rest/depts/1/emps
	@RequestMapping(value="/{id}/emps", method= RequestMethod.POST, produces = "application/json")
	@ResponseStatus( HttpStatus.CREATED )
	public void AddEmpToDept(@PathVariable("id") Long deptId,@RequestBody Emp emp)
	{
		Dept dept = deptDao.findById(deptId);
		
		emp.setDept(dept);
		dept.getEmps().add(emp);
		
		empDao.register(emp);
		deptDao.update(dept);

/* ResponseEntity is a wrapper for a response and, optionally, HTTP headers and a status code.
 The code below will return "201 Created" Heep status and the "Location" header for the resource
 after insertion: http://localhost:8080/SpringMvcJpaJBoss/rest/depts/1/emps/1

 URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(emp.getEmpId()).toUri();

        return ResponseEntity.created(location).build();
 */

	}

}
