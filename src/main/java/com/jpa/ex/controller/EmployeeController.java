/**
 * 
 */
package com.jpa.ex.controller;

import java.net.URI;
import java.util.Set;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpa.ex.model.Employee;
import com.jpa.ex.service.IEmployeeService;

/**
 * @author tk9kxh
 *
 */
@RestController
@RequestMapping("/")
public class EmployeeController{
	
	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping(value="/employees")
	public ResponseEntity<?> getAllEmployee(){
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@RequestMapping(value="/")
	public String getEmployee(){
		return employeeService.getAllEmployee().toString();
	}
	
	@RequestMapping(value="/addEmployees",method=RequestMethod.POST)
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp){
		try{
            Employee createdEmp = employeeService.addEmployee(emp);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path(createdEmp.getId().toString())
                         .build().toUri();
            return ResponseEntity.created(location).build();
     } catch(DataIntegrityViolationException e){
            String exceptionReturn = "";
            if(e.getCause() instanceof ConstraintViolationException){
                  String constraintName = ((ConstraintViolationException)e.getCause()).getConstraintName();
                  exceptionReturn = String.format("%s is mandatory in create employee request", constraintName);
            }
            return ResponseEntity.badRequest().body(exceptionReturn);
     }  
	}
	
	@RequestMapping(value="/updateRole/{emp_id}/{role_id}",method=RequestMethod.PUT)
	public ResponseEntity<?> assignRoleToEmployee(@PathVariable("emp_id") Long emp_id,
			@PathVariable("role_id") Long role_id){
		try{
			Employee createdEmp = employeeService.assignRole(emp_id, role_id);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path((createdEmp.getId()).toString())
                         .build().toUri();
            return ResponseEntity.ok(location);
     } catch(DataIntegrityViolationException e){
            String exceptionReturn = "";
            if(e.getCause() instanceof ConstraintViolationException){
                  String constraintName = ((ConstraintViolationException)e.getCause()).getConstraintName();
                  exceptionReturn = String.format("%s is mandatory to assign employee request", constraintName);
            }
            return ResponseEntity.badRequest().body(exceptionReturn);
     }  
	}
	
	@RequestMapping(value="/updateProject/{emp_id}/{project_id}",method=RequestMethod.PUT)
	public ResponseEntity<?> assignProjectToEmployee(@PathVariable("emp_id") Long emp_id,
			@PathVariable("project_id") Long project_id){
		try{
			Employee createdEmp = employeeService.assignProject(emp_id, project_id);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path((createdEmp.getId()).toString())
                         .build().toUri();
            return ResponseEntity.ok(location);
     } catch(DataIntegrityViolationException e){
            String exceptionReturn = "";
            if(e.getCause() instanceof ConstraintViolationException){
                  String constraintName = ((ConstraintViolationException)e.getCause()).getConstraintName();
                  exceptionReturn = String.format("%s is mandatory to assign employee request", constraintName);
            }
            return ResponseEntity.badRequest().body(exceptionReturn);
     }  
	}
	
	@RequestMapping(value="/updateDepartment/{emp_id}/{dept_id}",method=RequestMethod.PUT)
	public ResponseEntity<?> assignDepartmentToEmployee(@PathVariable("emp_id") Long emp_id,
			@PathVariable("dept_id") Long dept_id){
		try{
			Employee createdEmp = employeeService.assignDepartment(emp_id, dept_id);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path((createdEmp.getId()).toString())
                         .build().toUri();
            return ResponseEntity.ok(location);
     } catch(DataIntegrityViolationException e){
            String exceptionReturn = "";
            if(e.getCause() instanceof ConstraintViolationException){
                  String constraintName = ((ConstraintViolationException)e.getCause()).getConstraintName();
                  exceptionReturn = String.format("%s is mandatory to assign employee request", constraintName);
            }
            return ResponseEntity.badRequest().body(exceptionReturn);
     }  
	}
	
	@RequestMapping(value="/updateAddress/{emp_id}/{address_id}",method=RequestMethod.PUT)
	public ResponseEntity<?> assignAddressToEmployee(@PathVariable("emp_id") Long emp_id,
			@PathVariable("address_id") Long address_id){
		try{
			Employee createdEmp = employeeService.assignAddress(emp_id, address_id);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path((createdEmp.getId()).toString())
                         .build().toUri();
            return ResponseEntity.ok(location);
     } catch(DataIntegrityViolationException e){
            String exceptionReturn = "";
            if(e.getCause() instanceof ConstraintViolationException){
                  String constraintName = ((ConstraintViolationException)e.getCause()).getConstraintName();
                  exceptionReturn = String.format("%s is mandatory to assign employee request", constraintName);
            }
            return ResponseEntity.badRequest().body(exceptionReturn);
     }  
	}
	
	@RequestMapping(value="/assignManager/{emp_id}",method=RequestMethod.PUT)
	public ResponseEntity<?> assignMangerToEmployee(@RequestBody Set<Employee> setEmp,
			@PathVariable("emp_id") Long emp_id){
		try{
			Employee createdEmp = employeeService.assignManager(emp_id, setEmp);
            URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                         .path((createdEmp.getId()).toString())
                         .build().toUri();
            return ResponseEntity.ok(location);
     } catch(DataIntegrityViolationException e){
            String exceptionReturn = "";
            if(e.getCause() instanceof ConstraintViolationException){
                  String constraintName = ((ConstraintViolationException)e.getCause()).getConstraintName();
                  exceptionReturn = String.format("%s is mandatory to assign employee request", constraintName);
            }
            return ResponseEntity.badRequest().body(exceptionReturn);
     }  
	}
	
}
