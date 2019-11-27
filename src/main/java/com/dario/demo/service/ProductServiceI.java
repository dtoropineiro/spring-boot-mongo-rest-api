package com.dario.demo.service;

import java.util.List;
import java.util.Optional;

import com.dario.demo.model.Product;

public interface ProductServiceI {

	String addProduct(Product product);
	List<Product> getProducts();
	Optional<Product> getProductByID(Integer id);
	List<Product> findGreaterThanPrice(Integer price);
	List<Product> findByNameLike(String name);
	String deleteProductByID(Integer id);
}
