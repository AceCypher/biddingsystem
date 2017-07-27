package com.obs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.obs.pojos.Customer;
//@Repository
public interface CustomerDao {
	
	Customer registerCustomer(Customer c);

	List<Customer> listCustomers();

	Customer validateCustomer(String em, String pass);

	Customer updateCustomer(Customer c);

	String deleteCustomer(Integer id);

	Customer getCustomerById(Integer id);

}
