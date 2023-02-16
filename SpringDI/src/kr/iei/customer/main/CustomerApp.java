package kr.iei.customer.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.iei.customer.domain.Customer;
import kr.iei.customer.service.CustomerService;
import kr.iei.customer.service.logic.CustomerServiceImpl;

public class CustomerApp {

	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		Customer cusOne = (Customer)ctx.getBean("customer");
		System.out.println(cusOne);

		// 스프링이 객체 생성을 대신 해준다.
		// CustomerService cService = new CustomerServiceImpl();
		CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
		
		List<Customer> List = cService.findAllcustomers();
		for (Customer cOne : List) {
			System.out.println(cOne);
		}
	}

}
