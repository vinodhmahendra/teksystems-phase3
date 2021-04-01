package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer theCustomer) {
		return customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer theId) {
		return customerRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer theId) {
		customerRepository.deleteById(theId);
	}
}
