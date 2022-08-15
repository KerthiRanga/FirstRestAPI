package com.myfirst.springex.springController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myfirst.springex.dao.EmployeeDAO;
import com.myfirst.springex.model.Employee;
import com.myfirst.springex.model.Employees;
 

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeDAO employeeDao;
     
    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }
     
    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) 
    {
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
         
        employeeDao.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
    
	/*
	 * @DeleteMapping(path = "/delete/{id}", consumes = "application/json", produces
	 * = "application/json") public Employees deleteEmployee(@PathParam("id") Long
	 * id) {
	 * 
	 * System.out.println("getting the ID" + id);
	 * 
	 * Employees empList = employeeDao.deleteEmployee(id);
	 * 
	 * return empList;
	 * 
	 * }
	 */
    
    @DeleteMapping(path = "/delete/{id}")
    public Employees deleteEmployee(@PathVariable("id") Integer id) {
    	
    	System.out.println("getting the ID" + id);
    	
    	Employees empList = employeeDao.deleteEmployee(id);
    	
    	return empList;
    	
    }
	
	

}
