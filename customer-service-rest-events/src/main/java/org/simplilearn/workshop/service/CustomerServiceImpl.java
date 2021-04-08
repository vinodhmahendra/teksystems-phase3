package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.events.CustomerEvent;
import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "customerService") // publisher
public class CustomerServiceImpl implements CustomerService,ApplicationEventPublisherAware{
	
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
		Customer customer = customerRepository.save(theCustomer);
		applicationEventPublisher.publishEvent(new CustomerEvent(this, "CREATE", customer));
		return customer;
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

	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher=applicationEventPublisher;	
	}
}
