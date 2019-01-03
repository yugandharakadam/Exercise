/**
 * 
 */
package com.jpa.ex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.ex.model.Department;
import com.jpa.ex.repo.DepartmentRepository;
import com.jpa.ex.service.IDepartmentService;

/**
 * @author tk9kxh
 *
 */
@Component
public class DepartmentService implements IDepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
		}

	@Override
	public void deleteDepartment(long l) {
		departmentRepository.delete(l);
	}

	@Override
	public Department getDeapartmentById(Long id) {
		return departmentRepository.findOne(id);
	}

}
