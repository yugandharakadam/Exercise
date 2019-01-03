/**
 * 
 */
package com.jpa.ex.service;

import com.jpa.ex.model.Role;

/**
 * @author tk9kxh
 *
 */
public interface IRoleService {
	
	public Role addRole(Role role);

	public Role getRoleById(long l);

	public Role updateRole(long l);

}
