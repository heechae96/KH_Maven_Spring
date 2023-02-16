package kr.iei.customer.store;

import java.util.List;

import kr.iei.customer.domain.Customer;

public interface CustomerStore {
	
	public Customer selectOneById(String id);
	
	public List<Customer> selectAllCustomers();
}
