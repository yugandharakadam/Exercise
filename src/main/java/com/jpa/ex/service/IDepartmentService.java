/**
 * 
 */
package com.jpa.ex.service;

import com.jpa.ex.model.Department;

/**
 * @author tk9kxh
 *
 */
public interface IDepartmentService {

	Department addDepartment(Department department);

	void deleteDepartment(long l);

	Department getDeapartmentById(Long id);

}
