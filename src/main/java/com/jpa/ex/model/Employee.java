/**
 * 
 */
package com.jpa.ex.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author tk9kxh
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee extends MindEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Login_Name")
	private String loginName;
	
	@Column(name="Title")
	private String title;
	
	private Address address;
	private Set<Role> role;
	private Department department;
	private Set<Project> projects;
	private Set<Employee> employee;
	
	public Employee(){}
	
	public Employee(String firstName,String lastName,String loginName,String title){
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginName = loginName;
		this.title = title;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
	
	/**
	 * @return the address
	 */
	@OneToOne
	@JoinColumn(name="address_id",referencedColumnName="id")
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the department
	 */
	@ManyToOne
	@JoinColumn(referencedColumnName="department_id")
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", loginName=" + loginName + ", title="
				+ title + ", address=" + address + ", role=" + role + ", department=" + department + "]";
	} 
	
	/**
	 * @return the role
	 */
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id",updatable=false))
	/*@JsonManagedReference*/
	@JsonIgnoreProperties("employee")
	public Set<Role> getRole() {
		return role;
	}
	
	/**
	 * @return the projects
	 */
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id",updatable=false))
	public Set<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	/**
	 * @return the employee
	 */
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="employee_employee",joinColumns = @JoinColumn(name="emp_id",referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name = "emp1_id",referencedColumnName="id",updatable=false))
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
