package com.dario.demo.service;

import java.util.List;
import java.util.Optional;

import com.dario.demo.model.Product;

public interface ProductServiceI {

	public String addProduct(Product product);
	public List<Product> getProducts();
	public Optional<Product> getProductByID(Integer id);
	public String deleteProductByID(Integer id);
}
