package kr.iei.customer.service.logic;

import java.util.List;

import kr.iei.customer.domain.Customer;
import kr.iei.customer.service.CustomerService;
import kr.iei.customer.store.CustomerStore;

public class CustomerServiceImpl implements CustomerService {

	private CustomerStore cStore;

	// 1. setter메소드를 이용한 의존성 주입
	// public void setCustomerStore(CustomerStore cStore) {
	public void setStore(CustomerStore cStore) {
		this.cStore = cStore;
	}
	
	// 2. 생성자를 이용한 의존성 주입
	public CustomerServiceImpl(CustomerStore cStore) {
		this.cStore = cStore;
	}

	public CustomerServiceImpl() {
		// 스프링이 객체 생성을 대신 해준다.
		// cStore = new CustomerStoreImpl();
	}

	@Override
	public Customer findOneById(String id) {
		return cStore.selectOneById(id);
	}

	@Override
	public List<Customer> findAllcustomers() {
		return cStore.selectAllCustomers();
	}

}
