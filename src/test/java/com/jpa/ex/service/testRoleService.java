/**
 * 
 */
package com.jpa.ex.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.jpa.ex.model.Role;

/**
 * @author tk9kxh
 *
 */
@SpringBootTest
public class testRoleService  extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private IRoleService iRoleService;
	
	@Test
	public void testAddRole(){
		Role role = new Role();
		role.setName("Tester");
		role = iRoleService.addRole(role);
		Assert.assertNotNull(role);
	}
	
	@Test
	public void testGetRoleById(){
		Role role = iRoleService.getRoleById(1L);
		Assert.assertNotNull(role);
	}
	
	@Test
	public void testUpdateRole(){
		Role role = iRoleService.updateRole(1L);
		Assert.assertNotNull(role);
	}
	
}
