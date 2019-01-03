/**
 * 
 */
package com.jpa.ex.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpa.ex.model.Address;
import com.jpa.ex.service.IAddressService;

/**
 * @author tk9kxh
 *
 */
@RestController
@RequestMapping("/Address")
public class AddressController {

	@Autowired
	private IAddressService addressService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResponseEntity<?> addAddress(Address address){
		Address newAddress = addressService.addAddress(address);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(newAddress.getId().toString())
                .build().toUri();
		return ResponseEntity.created(location).build();
		
	}
}
