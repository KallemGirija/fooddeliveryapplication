package com.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("select c from Customer c where c.username=:username and c.password=:password")
	Customer validateCustomer(String username, String password);

	/*
	 * @Query("select new CustomerMembership(c.customer_id, COUNT(c.customer_id)) from Customer c"
	 * ) List<Customer> countTotalCustomers();
	 */

	
}
