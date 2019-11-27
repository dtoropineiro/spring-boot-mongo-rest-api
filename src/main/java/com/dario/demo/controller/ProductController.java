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

import com.dario.demo.model.Product;
import com.dario.demo.service.ProductServiceI;

@RestController("/")
public class ProductController {
	
	@Autowired
	private ProductServiceI productService;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/filter/{price}")
	public List<Product> filterProducts(@PathVariable Integer price){
		return productService.findGreaterThanPrice(price);
	}
	
	@GetMapping("/filter/name/{name}")
	public List<Product> filterProducts(@PathVariable String name){
		return productService.findByNameLike(name);
	}

	@GetMapping("/getProducts/{id}")
	public Optional<Product> getProductByID(@PathVariable Integer id){
		return productService.getProductByID(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProductByID(@PathVariable Integer id){
		
		return productService.deleteProductByID(id);
	}
}
