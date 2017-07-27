package com.obs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.obs.pojos.Customer;
//@Service
public interface CustomerService {
	
	String registerCustomer(Customer c);

	String validateCustomer(String em, String pass);

	List<Customer> listCustomers();

	String updateCustomer(Customer c);

	String deleteCustomer(Integer id);

	Customer getCustomerById(Integer id);

}
