/**
 * 
 */
package com.jpa.ex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.ex.model.Employee;

/**
 * @author tk9kxh
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByFirstName(String firstName);


}
