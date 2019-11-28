package com.dario.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dario.demo.dao.ProductRepository;
import com.dario.demo.model.Product;
import com.dario.sequence.dao.SequenceDaoI;

@Service
public class ProductService implements ProductServiceI{

	private static final String PRODUCT_SEQ_KEY = "Product";
	
	@Autowired
	private SequenceDaoI sequenceDao;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public String addProduct(Product product) {
		product.setId(sequenceDao.getNextSequenceId(PRODUCT_SEQ_KEY));
		productRepository.save(product);
		return "Added product with id: " + product.getId();
	}
	@Override
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	@Override
	public Optional<Product> getProductByID(Integer id){
		return productRepository.findById(id);
	}
	@Override
	public String deleteProductByID(Integer id){
		productRepository.deleteById(id);
		return "Deleted product with id: " + id;
	}
	@Override
	public List<Product> findGreaterThanPrice(Integer price) {
		List<Product> productList = productRepository.findAll();
		List<Product> productListFiltred = 
				productList.stream()
				.filter(p -> p.getPrice() > price)
				.collect(Collectors.toList());
		return productListFiltred;
	}
	@Override
	public List<Product> findByNameLike(String name) {
		List<Product> productList = productRepository.findAll();
		List<Product> productListFiltred = 
				productList.stream()
				.filter(p -> p.getName().contains(name))
				.collect(Collectors.toList());
		return productListFiltred;
	}
	@Override
	public List<Product> findBetweenPrices(Integer min, Integer max) {
		List<Product> productList = productRepository.findAll();
		List<Product> productListFiltred = 
				productList.stream()
				.filter(p -> (p.getPrice() < max) && (p.getPrice() > min))
				.collect(Collectors.toList());
		return productListFiltred;
	}
}
