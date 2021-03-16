package com.smartchoice.crawler.service;

import java.util.List;

import com.smartchoice.common.model.Product;

public interface ProductService {

	public void save(Product prod);
	public List findByKeyword (String keyword);
}
