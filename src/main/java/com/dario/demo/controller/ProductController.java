package com.dario.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dario.demo.dao.ProductRepository;
import com.dario.demo.model.Product;

@RestController("/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		productRepository.save(product);
		
		return "Added product with id: " + product.getId();
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts(){
		
		return productRepository.findAll();
	}

	@GetMapping("/getProducts/{id}")
	public Optional<Product> getProductByID(@PathVariable Integer id){
		
		return productRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProductByID(@PathVariable Integer id){
		productRepository.deleteById(id);
		return "Added product with id: " + id;
	}
}
