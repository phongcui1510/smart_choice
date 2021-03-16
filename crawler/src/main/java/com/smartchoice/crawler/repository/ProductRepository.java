package com.smartchoice.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartchoice.common.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
