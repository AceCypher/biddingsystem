package com.obs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.obs.pojos.*;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory factory;

	@Override
	public Product addProduct(Product b) {
		System.out.println("Dao : add Product product "
				+ factory.getCurrentSession().save(b));
		return b;
	}
	@Override
	public Product getProductById(Integer id) {
		return (Product) factory.getCurrentSession().get(Product.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		return factory.getCurrentSession()
				.createQuery("from Product b",Product.class).getResultList();

	}

	@Override
	public String deleteProduct(Product p) {
		String status="Product from Product deletion failed";
		if(p != null) {
			factory.getCurrentSession().delete(p);
			status="Product with ID "+p.getId()+" deleted successfully";
		}
		return status;
	}
	
}
