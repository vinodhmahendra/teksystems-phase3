package org.simplilearn.workshop;

import java.util.List;

import org.simplilearn.workshop.config.CustomerServiceConfig;
import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {

	public static void main(String[] args) {
	
		// create a spring container
		AnnotationConfigApplicationContext springContainer =
				new AnnotationConfigApplicationContext(CustomerServiceConfig.class);
		
		//retrieve a customerService bean from spring container 
		CustomerService customerService = springContainer.getBean("customerService",CustomerService.class);
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		for(Customer customer : loadedCustomers) {
			System.out.println(customer.getName());
		}
	}

}
