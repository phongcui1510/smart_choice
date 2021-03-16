package com.smartchoice.audit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartchoice.audit.repository.CustomerActivityRepository;
import com.smartchoice.audit.service.CustomerActivityService;
import com.smartchoice.common.model.CustomerActivity;

@Service
public class CustomerActivityServiceImpl implements CustomerActivityService {

	@Autowired
	private CustomerActivityRepository repository;
	
	@Override
	public List<CustomerActivity> getCustomerActivity() {
		return (List<CustomerActivity>) repository.findAll();
	}

}
