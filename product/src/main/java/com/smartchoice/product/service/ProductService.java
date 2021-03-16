package com.smartchoice.product.service;

import java.util.List;
import java.util.Optional;

import com.smartchoice.common.model.Product;

public interface ProductService {

	public void save(Product prod);
	public List findByKeyword (String keyword);
	public Optional<Product> findById (Integer id);
}
