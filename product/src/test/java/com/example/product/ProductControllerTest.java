package com.example.product;

import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.smartchoice.common.model.Product;
import com.smartchoice.product.ProductApplication;
import com.smartchoice.product.restclient.CrawlerProductRestClient;

@SpringBootTest(classes = ProductApplication.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class ProductControllerTest {

	@Autowired
	private CrawlerProductRestClient restClient;
	
    @Autowired
    private MockMvc restFriendshipMockMvc;
	
	@Test
	public void testGetProductByKeyword() throws Exception {
		List<Product> products = new ArrayList<Product>();
    	Product p1 = new Product();
    	p1.setId(1);
    	p1.setProductName("product1");
    	p1.setProductPrice("100$");
    	p1.setDiscount("10%");
    	p1.setFinalPrice("80%");
    	p1.setProductDescription("laptop Asus Gaming Model GBAJ12343");
    	p1.setImgUrl("https://media/product/35099_33507_32787_asus_x409ma_3.jpg");
    	p1.setSource("Lazada.com");
    	products.add(p1);
    	Product p2 = new Product();
    	p2.setId(2);
    	p2.setProductName("product2");
    	p2.setProductPrice("200$");
    	p2.setImgUrl("https://media/product/acer_123.jpg");
    	p2.setProductDescription("laptop Acer Nitro GBJ132423");
    	p2.setDiscount("10%");
    	p2.setFinalPrice("180%");
    	p2.setSource("Tiki.com");
    	products.add(p2);
    	
		restFriendshipMockMvc.perform(get("/findProductByKeyword?keyword=laptop").header("Username", "test"))
				.andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	            .andExpect(jsonPath("$.[*].id").value(hasItem(products.get(0).getId().intValue())));
	}
}
