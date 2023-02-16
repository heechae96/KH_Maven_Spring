package kr.iei.customer.store.logic;

import java.util.ArrayList;
import java.util.List;

import kr.iei.customer.domain.Customer;
import kr.iei.customer.store.CustomerStore;

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
