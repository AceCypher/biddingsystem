package com.obs.service;

import java.util.List;

import com.obs.pojos.*;
public interface IProductService {

	public Product addProduct(Product b);

	public Product getProduct(Integer id);

	public List<Product> getAllProducts();

	public String deleteProduct(Product p);

}
