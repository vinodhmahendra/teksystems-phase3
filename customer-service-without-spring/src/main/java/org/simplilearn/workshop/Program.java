package org.simplilearn.workshop;

import java.util.List;

import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.service.CustomerService;
import org.simplilearn.workshop.service.CustomerServiceImpl;

public class Program {

	public static void main(String[] args) {
		CustomerService customerService = new CustomerServiceImpl();
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
		
		for(Customer customer : loadedCustomers) {
			System.out.println(customer.getName());
		}
	}

}
