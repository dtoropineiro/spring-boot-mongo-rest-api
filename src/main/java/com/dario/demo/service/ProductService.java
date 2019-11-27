package com.dario.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dario.demo.dao.ProductRepository;
import com.dario.demo.model.Product;

@Service
public class ProductService implements ProductServiceI{

	@Autowired
	private ProductRepository productRepository;
	
	public String addProduct(Product product) {
		productRepository.save(product);
		return "Added product with id: " + product.getId();
	}
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	public Optional<Product> getProductByID(Integer id){
		return productRepository.findById(id);
	}
	public String deleteProductByID(Integer id){
		productRepository.deleteById(id);
		return "Deleted product with id: " + id;
	}
}
