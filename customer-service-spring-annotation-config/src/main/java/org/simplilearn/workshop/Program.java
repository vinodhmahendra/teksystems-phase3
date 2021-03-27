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
		
		//retrieve a customerService1 bean from spring container 
		CustomerService customerService1 = springContainer.getBean("customerService",CustomerService.class);
		
		List<Customer> loadedCustomers = customerService1.retrieveAllCustomers();
		
		//retrieve a customerService2 bean from spring container 
		CustomerService customerService2 = springContainer.getBean("customerService",CustomerService.class);
		
		for(Customer customer : loadedCustomers) {
			System.out.println(customer.getName());
		}
		
		if (customerService1 == customerService2) {
			System.out.println("they are identical");
		}else {
			System.out.println("they are not identical");
		}
	}

}
