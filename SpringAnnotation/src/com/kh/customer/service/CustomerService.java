package com.kh.customer.service;

import java.util.List;

import com.kh.customer.domain.Customer;

public interface CustomerService {
	
	public Customer findOneById(String id);
	
	public List<Customer> findAllcustomers();

}
