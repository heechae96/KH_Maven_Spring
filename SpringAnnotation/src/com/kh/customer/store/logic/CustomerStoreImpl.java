package com.kh.customer.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kh.customer.domain.Customer;
import com.kh.customer.store.CustomerStore;

@Component("customerStore")
public class CustomerStoreImpl implements CustomerStore {

	@Override
	public Customer selectOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> selectAllCustomers() {
		List<Customer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Customer cOne = new Customer(i + "", i + "", i + "", i + "");
			list.add(cOne);
		}
		return list;
	}

}
