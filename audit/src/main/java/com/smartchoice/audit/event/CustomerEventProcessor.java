package com.smartchoice.audit.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.smartchoice.audit.repository.CustomerActivityRepository;
import com.smartchoice.common.model.CustomerActivity;

@EnableBinding(Sink.class)
public class CustomerEventProcessor {
    private final CustomerActivityRepository activityRepository;

    @Autowired
    public CustomerEventProcessor(CustomerActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @StreamListener(Sink.INPUT)
    public void processCustomerEvent(CustomerActivity customerActivity) {
    	System.err.println("Received Data::"+customerActivity.getSearchKeyword());
        activityRepository.save(customerActivity);
    }
}
