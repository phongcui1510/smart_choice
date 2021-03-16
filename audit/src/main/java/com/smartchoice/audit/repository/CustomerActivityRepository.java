package com.smartchoice.audit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smartchoice.common.model.CustomerActivity;

@Repository
public interface CustomerActivityRepository extends CrudRepository<CustomerActivity, String> {
}
