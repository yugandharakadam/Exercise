/**
 * 
 */
package com.jpa.ex.service;

import java.util.List;
import java.util.Set;

import com.jpa.ex.model.Employee;

/**
 * @author tk9kxh
 *
 */
public interface IEmployeeService {

		List<Employee> getAllEmployee();

	Employee addEmployee(Employee emp);

	Employee assignRole(Long employeeId, Long roleId);

	Employee assignDepartment(long l, long m);

	Employee assignProject(long l, long m);

	Employee assignAddress(long l, long m);

	Employee assignManager(Long emp_id, Set<Employee> empList);


}
