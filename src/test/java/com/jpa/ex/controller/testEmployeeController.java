/**
 * 
 */
package com.jpa.ex.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.jpa.ex.model.Address;
import com.jpa.ex.model.AddressDetails;
import com.jpa.ex.model.Department;
import com.jpa.ex.model.Employee;
import com.jpa.ex.model.Project;
import com.jpa.ex.model.Role;
import com.jpa.ex.service.IAddressService;
import com.jpa.ex.service.IDepartmentService;
import com.jpa.ex.service.IEmployeeService;
import com.jpa.ex.service.IProjectService;
import com.jpa.ex.service.IRoleService;

/**
 * @author tk9kxh
 *
 */
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class testEmployeeController extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IAddressService addressService;
	
	@BeforeClass
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac).alwaysDo(print()).apply(SecurityMockMvcConfigurers.springSecurity()).build(); 
	}
	
	@Test
    public void testGetEmployee() throws Exception{
        mockMvc.perform(get("/employees").with(user("user").password("password").roles("USER")).contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk());    
    } 
	
	@Test(dataProvider="provideDummyEmployee")
    public void testAddEmployee(Employee tempEmp) throws Exception{
		Gson gson = new Gson();
	    String empJson = gson.toJson(tempEmp);
        mockMvc.perform(post("/addEmployees").with(csrf().asHeader()).with(user("user").password("password").roles("USER")).
        		contentType(MediaType.APPLICATION_JSON).content(empJson)).andExpect(status().isCreated());    
    } 
	
	@Test(dataProvider="provideDummyRole",dependsOnMethods="testAddEmployee")
    public void testAssignRoleEmployee(Role tempRole) throws Exception{
		Employee emp = employeeService.addEmployee(employeeService.getAllEmployee().get(0));
		Role role = roleService.addRole(tempRole);
		String strURI= String.format("/updateRole/%s/%s", emp.getId(),role.getId());
        mockMvc.perform(put(strURI).with(csrf().asHeader()).with(user("user").password("password").roles("USER"))).
        		andExpect(status().isOk());
    }
	
	@Test(dataProvider="provideDummyProject",dependsOnMethods="testAddEmployee")
	public void testAssignProjecttoEmployee(Project tempProject) throws Exception{
		Employee emp = employeeService.addEmployee(employeeService.getAllEmployee().get(0));
		Project project = projectService.addProject(tempProject);
		String strURI= String.format("/updateProject/%s/%s", emp.getId(),project.getId());
		mockMvc.perform(put(strURI).with(user("user").password("password").roles("USER")).with(csrf().asHeader())).
			andExpect(status().isOk());
	}
	
	@Test(dataProvider="provideTempDept",dependsOnMethods="testAddEmployee")
	public void testAssignDepartmentToEmployee(Department department) throws Exception{
		Employee emp = employeeService.addEmployee(employeeService.getAllEmployee().get(0));
		Department newDepartment = departmentService.addDepartment(department);
		String strURI= String.format("/updateDepartment/%s/%s", emp.getId(),newDepartment.getId());
		mockMvc.perform(put(strURI).with(user("user").password("password").roles("USER")).
				with(csrf().asHeader())).andExpect(status().isOk());
	}
	
	@Test(dataProvider="provideAddressObject",dependsOnMethods="testAddEmployee")
	public void testAssignAddressToEmployee(Address address) throws Exception{
		Employee emp = employeeService.addEmployee(employeeService.getAllEmployee().get(0));
		Address newAddress = addressService.addAddress(address);
		String strURI= String.format("/updateAddress/%s/%s", emp.getId(),newAddress.getId());
		mockMvc.perform(put(strURI).with(user("user").password("password").roles("USER")).
				with(csrf().asHeader())).andExpect(status().isOk());
	}
	
	@Test(dataProvider="provideDummyEmployee1",dependsOnMethods="testAddEmployee")
	public void testAssignEmployeesToManager(Employee emp) throws Exception{
		Employee empTemp = employeeService.addEmployee(emp);
		List<Employee> employeeList = employeeService.getAllEmployee();
		Set<Employee> setEmp = new HashSet<>(employeeList);
		Gson gson = new Gson();
		String strURI= String.format("/assignManager/%s", empTemp.getId());
		mockMvc.perform(put(strURI).with(user("user").password("password").roles("USER")).
				contentType(MediaType.APPLICATION_JSON).content(gson.toJson(setEmp)).
				with(csrf().asHeader())).andExpect(status().isOk());
	}
	
	@DataProvider
	public Object[][] provideDummyEmployee(){
		Employee tempEmp = new Employee();
		tempEmp.setTitle("Engineer");
		tempEmp.setFirstName("Yuga");
		tempEmp.setLastName("Kadam");
		tempEmp.setLoginName("ykadam");
		return new Object[][] {{tempEmp}};
	}
	
	@DataProvider
	public Object[][] provideDummyEmployee1(){
		Employee tempEmp = new Employee();
		tempEmp.setTitle("test");
		tempEmp.setFirstName("Yuga1");
		tempEmp.setLastName("Kadam2");
		tempEmp.setLoginName("ykadam3");
		return new Object[][] {{tempEmp}};
	}

	@DataProvider
	public Object[][] provideDummyRole(){
		Role tempRole = new Role();
		tempRole.setName("USER");
		return new Object[][] {{tempRole}};
	}
	
	@DataProvider
	public Object[][] provideDummyProject(){
		Project tempProject = new Project();
		tempProject.setName("MindSphere");
		return new Object[][] {{tempProject}};
	}
	
	@DataProvider
	private Object[][] provideTempDept(){
		Department department = new Department();
		department.setName("R&D");
		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setCity("Pune");
		addressDetails.setZip("411060");
		addressDetails.setStreet("Wakad");
		department.setAddress(addressDetails);
		return new Object[][]{{department}};
	}
	
	@DataProvider
	public Object[][] provideAddressObject(){
		AddressDetails addressDetails = new AddressDetails("Pune","411060","Wakad");
		Address address = new Address(addressDetails);
		return new Object[][]{{address}};
		
	}
	
}
