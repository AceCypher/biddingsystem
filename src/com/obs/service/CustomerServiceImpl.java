package com.obs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.dao.CustomerDao;
import com.obs.pojos.Customer;
import com.obs.service.CustomerService;
//@Repository1
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	public String registerCustomer(Customer c) {
		Customer c1 = dao.registerCustomer(c);
		if (c1.getId() == null)
			return "Customer Reg Failed";

		return "Customer reged successfully with ID " + c.getId();
	}

	@Override
	@Transactional(readOnly = true)
	public String validateCustomer(String em, String pass) {
		Customer c = dao.validateCustomer(em, pass);
		if (c == null)
			return "Customer Authentication Failed";

		return "Customer authenticated successfully " + c;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> listCustomers() {

		return dao.listCustomers();
	}

	@Override
	public String updateCustomer(Customer c) {

		 dao.updateCustomer(c);
		 return "Customer with ID "+c.getId() +" Updated successfully";
	}

	@Override
	public String deleteCustomer(Integer id) {

		return dao.deleteCustomer(id);
	}

	@Override
	public Customer getCustomerById(Integer id) {

		return dao.getCustomerById(id);
	}

}
