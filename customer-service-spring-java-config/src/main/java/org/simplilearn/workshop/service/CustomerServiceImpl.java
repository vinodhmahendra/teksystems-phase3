package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.repository.CustomerRepository;
import org.simplilearn.workshop.repository.ListCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	// declare a variable of customerRepository (property)
	private CustomerRepository customerRepository;
	
	//default constructor
	public CustomerServiceImpl() {
		super();
	}
	
	//parameterized constructor
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("spring container as called constructor to inject customerRepository bean -->");
		this.customerRepository = customerRepository;
	}
	
	//defined a setter method
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("spring container as called setter method to inject customerRepository bean --->");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	}

}
