/**
 * 
 *//*
package com.jpa.ex.auth;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpa.ex.model.Employee;
import com.jpa.ex.repo.EmployeeRepository;

*//**
 * @author tk9kxh
 *
 *//*
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByFirstName(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		//for (Role role : employee.getRole()){
	        grantedAuthorities.add(new SimpleGrantedAuthority("User"));
	    //}
		return new org.springframework.security.core.userdetails.User("username", "password", grantedAuthorities);
	}

}
*/