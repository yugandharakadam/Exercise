/**
 * 
 */
package com.jpa.ex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.ex.model.Address;

/**
 * @author tk9kxh
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
