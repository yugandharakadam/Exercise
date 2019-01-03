/**
 * 
 */
package com.jpa.ex.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.jpa.ex.model.Role;

/**
 * @author tk9kxh
 *
 */
@WebAppConfiguration
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class testRoleController extends AbstractTestNGSpringContextTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@BeforeClass
	public void init(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac).alwaysDo(print()).apply(SecurityMockMvcConfigurers.springSecurity()).build(); 
	}
	
	@Test(dataProvider="provideDummyRole")
	public void testAddRole(Role role){
		Gson gson = new Gson();
	    String roleJson = gson.toJson(role);
        try {
			mockMvc.perform(post("/Role/create").with(user("user").password("password").roles("ADMIN")).with(csrf().asHeader()).
					contentType(MediaType.APPLICATION_JSON).content(roleJson)).andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] provideDummyRole(){
		Role role = new Role();
		role.setName("User");
		return new Object[][] {{role}};
		
	}
	
}
