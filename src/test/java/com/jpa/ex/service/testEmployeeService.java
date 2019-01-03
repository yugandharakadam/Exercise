/**
 * 
 */
package com.jpa.ex.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jpa.ex.model.Address;
import com.jpa.ex.model.AddressDetails;
import com.jpa.ex.model.Department;
import com.jpa.ex.model.Employee;
import com.jpa.ex.model.Project;
import com.jpa.ex.model.Role;
import com.jpa.ex.repo.EmployeeRepository;

/**
 * @author tk9kxh
 *
 */
@SpringBootTest
@ActiveProfiles("test") 
public class testEmployeeService extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IRoleService iRoleService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private IAddressService addressService;
	
	@BeforeClass
	public void BeforeTest(){
		Role role = new Role("Developer");
		iRoleService.addRole(role);
		
		Department dept= new Department("Test",new AddressDetails("c1","z1","s1"));
		departmentService.addDepartment(dept);
		
		Project project= new Project("MS", new Date(), new Date());
		projectService.addProject(project);
		
		Address address = new Address(new AddressDetails("Pune","411060","Wakad"));
		addressService.addAddress(address);
	}
	
	@Test
	public void testAddEmployeeWithMinDetails(){
		Employee employee = new Employee();
		employee.setFirstName("First");
		employee.setLastName("last");
		employee.setLoginName("login");
		employee.setTitle("title");
		employee = employeeRepository.save(employee);
		Assert.assertNotNull(employee);
	}
	
	@Test
	public void testGetAllEmployee(){
		List<Employee> empList = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(empList::add);
		System.out.println(empList.size());
		Assert.assertEquals(true, empList.size()>0);
	}
	
	/*@Test
	public void testDeleteEmployee(){
		employeeRepository.delete(12L);
		Assert.assertNotNull(true);
	}*/
	
	@Test
	public void testAssignRoleToEmployee(){
		Employee emp = employeeService.assignRole(5L,1L);
		Assert.assertNotNull(emp);
		Assert.assertTrue(emp.getRole().size()>0);
	}	
	
	@Test
	public void testAssignDepartmentToEmployee(){
		Employee emp = employeeService.assignDepartment(5L,2L);
		Assert.assertNotNull(emp.getDepartment());
	}
	
	@Test
	public void testAssignProjectToEmployee(){
		Employee emp = employeeService.assignProject(5L,3L);
		Assert.assertNotNull(emp.getProjects());
	}
	
	/*@Test
	public void testAssignAddressToEmployee(){
		Employee emp = employeeService.assignAddress(5L,4L);
		Assert.assertNotNull(emp.getAddress());
	}*/
	
}
