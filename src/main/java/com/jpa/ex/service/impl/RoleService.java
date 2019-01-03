/**
 * 
 */
package com.jpa.ex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.ex.model.Role;
import com.jpa.ex.repo.RoleRepository;
import com.jpa.ex.service.IRoleService;

/**
 * @author tk9kxh
 *
 */
@Component
public class RoleService implements IRoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(long l) {
		return roleRepository.findOne(l);
	}

	@Override
	public Role updateRole(long l) {
		return roleRepository.save(roleRepository.findOne(l));
	}

}
