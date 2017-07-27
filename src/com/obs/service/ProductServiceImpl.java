package com.obs.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.obs.dao.*;
import com.obs.pojos.*;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductDao dao;

	@Override
	public Product addProduct(Product b) {
		Product c1 = dao.addProduct(b);
		if (c1.getId() == null)
			return null;
		return c1;
	}

	@Override
	@Transactional(readOnly = true)
	public Product getProduct(Integer id){
		return dao.getProductById(id);
	}

	@Override
	public List<Product> getAllProducts(){
		return dao.getProducts();
	}

	@Override
	public String deleteProduct(Product p){
		return dao.deleteProduct(p);
	}

}
