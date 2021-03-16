package com.smartchoice.crawler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartchoice.common.model.Product;
import com.smartchoice.crawler.repository.ProductRepository;
import com.smartchoice.crawler.service.ProductService;

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
		// TODO Auto-generated method stub
		return null;
	}

}
