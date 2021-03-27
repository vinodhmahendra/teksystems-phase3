package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Customer;

public interface CustomerService {

	public List<Customer> retrieveAllCustomers();
	
	public void insertCustomer(String name,String phone, String email);
}
