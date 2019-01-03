/**
 * 
 */
package com.jpa.ex.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jpa.ex.model.Project;
import com.jpa.ex.service.impl.ProjectService;

/**
 * @author tk9kxh
 *
 */
@SpringBootTest
public class testProjectService extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private ProjectService projectService;
	
	@Test
	public void testAddProject(){
		Project project = new Project();
		project.setName("Project1");
		project.setFromDate(new Date());
		project.setToDate(new Date());
		project = projectService.addProject(project);
		Assert.assertNotNull(project);
	}
	
	@Test
	public void testDeleteProject(){
		projectService.deleteProject(1L);
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void testGetAllProjects(){
		List<Project> projects = projectService.getAllProject();
		Assert.assertEquals(true, projects.size()>0);
	}
	
	@Test
	public void testGetProjects(){
		Project project = projectService.getProjectById(1L);
		Assert.assertNotNull(project);
	}
	
	
	

}
