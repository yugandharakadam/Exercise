/**
 * 
 */
package com.jpa.ex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.ex.model.Project;
import com.jpa.ex.repo.ProjectRepository;
import com.jpa.ex.service.IProjectService;

/**
 * @author tk9kxh
 *
 */
@Component
public class ProjectService implements IProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	
	@Override
	public void deleteProject(long projectId) {
		projectRepository.delete(projectId);
	}

	@Override
	public List<Project> getAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findOne(id);
	}

}
