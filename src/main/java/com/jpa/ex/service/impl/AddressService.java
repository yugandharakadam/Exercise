/**
 * 
 */
package com.jpa.ex.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.ex.model.Address;
import com.jpa.ex.repo.AddressRepository;
import com.jpa.ex.service.IAddressService;

/**
 * @author tk9kxh
 *
 */
@Component
public class AddressService implements IAddressService{
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address addAddress(Address project) {
		return addressRepository.save(project);
	}

}
