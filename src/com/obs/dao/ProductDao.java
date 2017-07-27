package com.obs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.obs.pojos.*;

public interface ProductDao {

	public Product addProduct(Product b);

    public Product getProductById(Integer id);

	public List<Product> getProducts();

	public String deleteProduct(Product p);

	//Upon completion of bidding, update user transaction and remove bid

}
