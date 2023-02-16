package com.kh.customer.store;

import java.util.List;

import com.kh.customer.domain.Customer;

public interface CustomerStore {
	
	public Customer selectOneById(String id);
	
	public List<Customer> selectAllCustomers();
}
