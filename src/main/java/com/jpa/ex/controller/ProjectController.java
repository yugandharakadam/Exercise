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

import com.jpa.ex.model.Project;
import com.jpa.ex.service.IProjectService;

/**
 * @author tk9kxh
 *
 */
@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	@Autowired
	private IProjectService projectService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<?> createProject(@RequestBody Project project){
		Project newProject = projectService.addProject(project);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(newProject.getId().toString())
                .build().toUri();
		return ResponseEntity.created(location).build();
	}
	
}
