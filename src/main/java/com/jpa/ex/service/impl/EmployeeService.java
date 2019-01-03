/**
 * 
 */
package com.jpa.ex.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.ex.model.Address;
import com.jpa.ex.model.Department;
import com.jpa.ex.model.Employee;
import com.jpa.ex.model.Project;
import com.jpa.ex.model.Role;
import com.jpa.ex.repo.AddressRepository;
import com.jpa.ex.repo.DepartmentRepository;
import com.jpa.ex.repo.EmployeeRepository;
import com.jpa.ex.repo.ProjectRepository;
import com.jpa.ex.repo.RoleRepository;
import com.jpa.ex.service.IEmployeeService;

/**
 * @author tk9kxh
 *
 */
@Component
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Employee> getAllEmployee(){
		List<Employee> empList = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(empList::add);
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		return empList; 
		
	}
	
	@Override
	public Employee assignRole(Long employeeId, Long roleId) {
		Employee emp = employeeRepository.findOne(employeeId);
		Role role = roleRepository.findOne(roleId);
		Set<Role> roles = new HashSet<>();
		for (Role role1 : emp.getRole()) {
			roles.add(role1);
		}
		roles.add(role);
		emp.setRole(roles);
		return employeeRepository.save(emp);
	}
	
	public Employee getEmployeeByFirstName(Long id){
		return employeeRepository.findOne(id);
	}

	@Override
	public Employee assignDepartment(long employeeId, long m) {
		Employee emp = employeeRepository.findOne(employeeId);
		Department dept = departmentRepository.findOne(m);
		emp.setDepartment(dept);
		return employeeRepository.save(emp);
	}

	@Override
	public Employee assignProject(long employeeId, long m) {
		Employee emp = employeeRepository.findOne(employeeId);
		Project proj = projectRepository.findOne(m);
		Set<Project> projects = new HashSet<>();
		for (Project project : emp.getProjects()) {
			projects.add(project);
		}
		projects.add(proj);
		emp.setProjects(projects);
		return employeeRepository.save(emp);
	}

	@Override
	public Employee assignAddress(long employeeId, long m) {
		Employee emp = employeeRepository.findOne(employeeId);
		Address address = addressRepository.findOne(m);
		emp.setAddress(address);
		return employeeRepository.save(emp);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee assignManager(Long emp_id, Set<Employee> empList) {
		Employee emp = employeeRepository.findOne(emp_id);
		emp.setEmployee(empList);
		return employeeRepository.save(emp);
	}
	
}
