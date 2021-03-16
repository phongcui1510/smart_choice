package com.smartchoice.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartchoice.common.model.Product;
import com.smartchoice.product.restclient.CrawlerProductRestClient;
import com.smartchoice.product.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CrawlerProductRestClient restClient;
	
    @GetMapping("/findProductByKeyword")
    public List<Product> getProductByKeyword(@RequestParam String keyword, @RequestHeader("Username") String customer) {
        return restClient.findProductByKeyword(keyword);
    }
    
    @Cacheable("products")
    @GetMapping("/getProductDetailsById")
    public Product getProductDetailsById(@RequestParam String id, @RequestHeader("Username") String customer) {
    	try {
    		Product product = productService.findById(Integer.valueOf(id)).orElse(null); // find product from our own DB
        	if (product == null) { // if not found
        		product = restClient.getProductDetailsById(id); // call external API to get product details
        		productService.save(product); // save to db
        	}
        	return product;
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
		}
    	return null;
    }
    
    @CacheEvict("products")
    public void clearCache (@RequestParam Long id, @RequestHeader("Username") String customer) {
    	// do some stuff
    	// we can write a schedule job to clear cache every 2-3 days, to avoid full cache
    }

}
