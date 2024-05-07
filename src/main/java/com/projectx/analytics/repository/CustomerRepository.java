package com.projectx.analytics.repository;

import com.projectx.analytics.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customers, String> {
   Customers findByUsername(String username);
}
