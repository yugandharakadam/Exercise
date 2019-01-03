/**
 * 
 */
package com.jpa.ex.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author tk9kxh
 *
 */
@Entity
@Table(name="DEPARTMENT")
@AttributeOverride( name="id", column = @Column(name="department_id") )
public class Department extends MindEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="name")
	private String name;
	private AddressDetails address;
	
    public Department(){}
	
	public Department(String name,AddressDetails address){
		this.name = name;
		this.address = address;
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
		return "Department [name=" + name + "]";
	}

	/**
	 * @return the address
	 */
	@Embedded
	public AddressDetails getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressDetails address) {
		this.address = address;
	}

}
