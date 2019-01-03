/**
 * 
 */
package com.jpa.ex.service;

import java.util.List;

import com.jpa.ex.model.Project;

/**
 * @author tk9kxh
 *
 */
public interface IProjectService {
	
	public Project addProject(Project project);
	
	public void deleteProject(long projectId);
	
	public List<Project> getAllProject();
	
	public Project getProjectById(Long id);

}
