package com.obs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.pojos.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public Customer registerCustomer(Customer c) {
		System.out.println("Dao : reg cust "
				+ factory.getCurrentSession().save(c));
		return c;
	}

	//@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {

		return factory.getCurrentSession()
				.createQuery("select c from Customer c",Customer.class).getResultList();
	}

	@Override
	public Customer validateCustomer(String em, String pass) {
		return (Customer) factory
				.getCurrentSession()
				.createQuery(
						"select c from Customer c where c.email = :em and c.password = :pass",Customer.class)
				.setParameter("em", em).setParameter("pass", pass)
				.getSingleResult();
	}

	@Override
	public Customer updateCustomer(Customer c) {

		factory.getCurrentSession().update(c);
		return c;
	}

	@Override
	public String deleteCustomer(Integer id) {
		String status="Customer deletion failed";
		Customer c=getCustomerById(id);
		if(c != null) {
			factory.getCurrentSession().delete(c);
			status="Customer with ID "+c.getId()+" deleted successfully";
		}
		return status;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return (Customer) factory.getCurrentSession().get(Customer.class, id);
	}

}
