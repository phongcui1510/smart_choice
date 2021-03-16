package com.smartchoice.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartchoice.audit.service.CustomerActivityService;
import com.smartchoice.common.model.CustomerActivity;

@RestController
@RequestMapping("/api")
public class AuditController {

	@Autowired
	private CustomerActivityService service;
	
    @GetMapping("/getCustomerActivities")
    public List<CustomerActivity> getCustomerActivities() {
        return service.getCustomerActivity();
    }

}
