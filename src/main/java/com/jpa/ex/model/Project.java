/**
 * 
 */
package com.jpa.ex.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author tk9kxh
 *
 */
@Entity
@Table(name="Project")
public class Project extends MindEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="Name",nullable=false)
	private String name;
	
	@Column(name="From_Date")//,nullable=false)
	private Date fromDate;
	
	@Column(name="To_Date")//,nullable=false)
	private Date toDate;
	
	public Project(){}
	
	public Project(String name,Date fDate,Date tdate){
		this.name = name;
		this.fromDate = fDate;
		this.toDate = tdate;
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
	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {	
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
}
