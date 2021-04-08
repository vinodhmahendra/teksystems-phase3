package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer saveCustomer(Customer theCustomer);

	public Customer getCustomer(Integer theId);

	public void deleteCustomer(Integer theId);

}
