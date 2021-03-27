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
	
		
		for(Customer customer : loadedCustomers) {
			System.out.println(customer.getName());
		}
		
		System.out.println("insert ayush data");
		customerService1.insertCustomer("ayush", "403274", "ayush@teksystems.com");
	
		
		
	}

}
