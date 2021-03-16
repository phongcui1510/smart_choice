package com.smartchoice.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

	@Value("${message.servicename}")
	private String message;
	
    @GetMapping("/ping")
    public String hi() {
    	return "Congrat! This is " + this.message;
    }
}
