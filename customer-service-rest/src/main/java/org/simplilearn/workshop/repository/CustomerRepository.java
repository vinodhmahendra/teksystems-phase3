package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.Customer;

public interface CustomerRepository {

	public List<Customer> getCustomers();

	public Customer saveCustomer(Customer theCustomer);

	public Customer getCustomer(Integer theId);

	public Customer deleteCustomer(Integer theId);

}
