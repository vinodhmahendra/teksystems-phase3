package org.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.simplilearn.workshop.model.Customer;

public class ListCustomerRepositoryImpl implements CustomerRepository {
	
	private static List<Customer> customers = new ArrayList<Customer>();
	
	static {
		customers.add(new Customer(101L, "vinodh", "vinodh@simplilearn.com", "1234567890"));
		customers.add(new Customer(102L, "clarence", "clarence@simplilearn.com", "34567890"));
		customers.add(new Customer(103L, "kavana", "kavana@simplilearn.com", "4567890"));
	}

	@Override
	public List<Customer> findAll() {
		return customers;
	}

}
