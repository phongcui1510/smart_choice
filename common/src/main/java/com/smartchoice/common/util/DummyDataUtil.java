package com.smartchoice.common.util;

import java.util.ArrayList;
import java.util.List;

import com.smartchoice.common.model.Product;

public class DummyDataUtil {

	public static List<Product> getListProduct (int numOfProduct) {
		List<Product> products = new ArrayList<Product>();
		for (int i=0;i<numOfProduct;i++) {
			Product p = new Product();
	    	p.setId(i+1);
	    	p.setProductName("product" + i);
	    	p.setProductPrice(String.valueOf(100 + i) + "$");
	    	p.setDiscount("10%");
	    	p.setFinalPrice("80%");
	    	p.setProductDescription("laptop Asus Gaming Model GBAJ12343");
	    	p.setImgUrl("https://media/product/35099_33507_32787_asus_x409ma_3.jpg");
	    	p.setSource("Lazada.com");
	    	products.add(p);
		}
    	return products;
	}
	
	public static Product getProduct() {
		Product p1 = new Product();
    	p1.setId(1);
    	p1.setProductName("product1");
    	p1.setProductPrice("100$");
    	p1.setDiscount("10%");
    	p1.setFinalPrice("80%");
    	p1.setProductDescription("laptop Asus Gaming Model GBAJ12343");
    	p1.setImgUrl("https://media/product/35099_33507_32787_asus_x409ma_3.jpg");
    	p1.setSource("Lazada.com");
    	return p1;
	}
}
