package com.smartchoice.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartchoice.common.model.Product;
import com.smartchoice.product.repository.ProductRepository;
import com.smartchoice.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void save(Product prod) {
		productRepository.save(prod);
	}

	@Override
	public List findByKeyword(String keyword) {
		return null;
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

}
