/**
 * 
 */
package com.jpa.ex.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.jpa.ex.model.AddressDetails;
import com.jpa.ex.model.Department;

/**
 * @author tk9kxh
 *
 */
@SpringBootTest
public class testDepartmentService extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Test
	public void testAddDepartment(){
		Department department = new Department();
		department.setName("R&D");

		AddressDetails address = new AddressDetails();
		address.setCity("Pune");
		address.setStreet("Wakad");
		address.setZip("4110744");
		department.setAddress(address);
		department=departmentService.addDepartment(department);
		Assert.assertNotNull(department);
	}
	
	@Test
	public void testDeleteDepartment(){
		departmentService.deleteDepartment(1L);
	}
	
	@Test
	public Department testGetDepartmentById(Long Id){
		Department department = departmentService.getDeapartmentById(Id);
		return department;
	}

}
