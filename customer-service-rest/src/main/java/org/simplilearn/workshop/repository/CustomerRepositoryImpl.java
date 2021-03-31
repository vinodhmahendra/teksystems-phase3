package org.simplilearn.workshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.simplilearn.workshop.model.Customer;
import org.springframework.stereotype.Repository;

@Repository(value = "customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

	private static List<Customer> customers = new ArrayList<Customer>();
	
	private static Integer customerCount = 3;

	static {
		customers.add(new Customer(101, "vinodh", "mahendra", "vinodh.mahendra@simplilearn.com"));
		customers.add(new Customer(102, "clarence", "tauro", "clarence@couchbase.com"));
		customers.add(new Customer(103, "dennis", "gregory", "dennis@simplilearn.com"));
	}

	@Override
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		if (theCustomer.getId() == null) {
			theCustomer.setId(++customerCount);
		}
		customers.add(theCustomer);
		return theCustomer;

	}

	@Override
	public Customer getCustomer(Integer theId) {
		for (Customer theCustomer : customers) {
			if (theCustomer.getId() == theId) {
				return theCustomer;
			}
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(Integer theId) {
		Iterator<Customer> iterator = customers.iterator();
		while ( iterator.hasNext()) {
			Customer theCustomer = iterator.next();
			if ( theCustomer.getId() == theId) {
				iterator.remove();
				return theCustomer;
			}
		}
		return null;
	}

}
