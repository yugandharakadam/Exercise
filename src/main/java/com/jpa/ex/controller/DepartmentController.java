/**
 * 
 */
package com.jpa.ex.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpa.ex.model.Department;
import com.jpa.ex.service.IDepartmentService;

/**
 * @author tk9kxh
 *
 */
@RestController
@RequestMapping("/Dept")
public class DepartmentController {
	
	@Autowired
	private IDepartmentService departmentService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<?> addDepartment(Department dept){
		Department newProject = departmentService.addDepartment(dept);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(newProject.getId().toString())
                .build().toUri();
		return ResponseEntity.created(location).build();
		
	}

}
