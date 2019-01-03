/**
 * 
 */
package com.jpa.ex.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpa.ex.model.Role;
import com.jpa.ex.service.IRoleService;

/**
 * @author tk9kxh
 *
 */
@RestController
@RequestMapping("/Role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<?> createRole(@RequestBody Role role){
		Role newRole = roleService.addRole(role);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(newRole.getId().toString())
                .build().toUri();
		return ResponseEntity.created(location).build();
	}

}
