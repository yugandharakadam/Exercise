package com.jpa.ex.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressDetails implements Serializable{

	private static final long serialVersionUID = 4L;

	private String city;

	private String zip;
	
	private String street;
	
	public AddressDetails() {
	}
	
	public AddressDetails(String city,String zip,String street) {
		this.city = city;
		this.zip = zip;
		this.street = street;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressDetails [city=" + city + ", zip=" + zip + ", street=" + street + "]";
	}

	@Column(name = "street")
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
