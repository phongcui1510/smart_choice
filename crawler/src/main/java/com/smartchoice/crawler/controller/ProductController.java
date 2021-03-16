package com.smartchoice.crawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartchoice.common.model.Product;
import com.smartchoice.common.util.DummyDataUtil;
import com.smartchoice.crawler.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/findAllProduct")
    public List<Product> getAllProducts() {
        return DummyDataUtil.getListProduct(5);
    }

    @GetMapping("/findProductByKeyword")
    public List<Product> getProductByKeyword(@RequestParam String keyword) {
    	return DummyDataUtil.getListProduct(3);
    }
    
    @GetMapping("/getProductDetailsById")
    public Product getProductDetailsById(@RequestParam String id) {
    	return DummyDataUtil.getProduct();
    }

}
