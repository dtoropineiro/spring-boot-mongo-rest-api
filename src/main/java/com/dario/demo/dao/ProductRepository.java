package com.dario.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dario.demo.model.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{

}
