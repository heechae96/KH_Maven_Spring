package kr.iei.customer.service;

import java.util.List;

import kr.iei.customer.domain.Customer;

public interface CustomerService {
	
	public Customer findOneById(String id);
	
	public List<Customer> findAllcustomers();

}
