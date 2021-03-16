package com.nthieu.auditservice.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.stream.messaging.Sink;

import com.smartchoice.audit.repository.CustomerActivityRepository;

@SpringBootTest
class CustomerEventProcessorTest {
    @Autowired
    private Sink sink;

    @MockBean
    private CustomerActivityRepository repository;

    @Test
    void whenNewCustomerActivitityComes_ThenSaveIt() {
//        CustomerActivity customerActivity = new CustomerActivity("1",
//                "Hieu", LocalDateTime.of(2020, 12, 12, 0, 0),
//                "product3", null, null);
//        Message<CustomerActivity> message = new GenericMessage<>(customerActivity);
//        sink.input().send(message);
//        Mockito.when(repository.save(Mockito.eq(customerActivity))).thenReturn(customerActivity);
//        Mockito.verify(repository).save(customerActivity);
    }
}