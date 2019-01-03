/**
 * 
 */
package com.jpa.ex.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author tk9kxh
 *
 */

@Entity
@Table(name="ROLE")
public class Role extends MindEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="Name")
	private String name;
	private Set<Employee> employee;
	
	public Role(){}

	public Role(String name){
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}

	/**
	 * @return the employee
	 */
	@ManyToMany(mappedBy = "role")
	@JsonIgnoreProperties("role")
	public Set<Employee> getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

}
