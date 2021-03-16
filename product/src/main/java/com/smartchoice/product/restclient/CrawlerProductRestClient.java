package com.smartchoice.product.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartchoice.common.model.Product;

@FeignClient("CRAWLER-SERVICE")
public interface CrawlerProductRestClient {

	@RequestMapping(method = RequestMethod.GET, value = "/api/findProductByKeyword")
    List<Product> findProductByKeyword(@RequestParam String keyword);
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/getProductDetailsById")
	Product getProductDetailsById(@RequestParam String id);
}
