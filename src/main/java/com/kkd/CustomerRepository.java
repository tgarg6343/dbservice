package com.kkd;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String>{

	public Optional<Customer> findByCustomerId(String customerId);
	public Optional<Customer> findByMobileNo(String mobileNo);
}
