package org.simplilearn.workshop.config;

import org.simplilearn.workshop.repository.CustomerRepository;
import org.simplilearn.workshop.repository.ListCustomerRepositoryImpl;
import org.simplilearn.workshop.service.CustomerService;
import org.simplilearn.workshop.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 3 bean , customerService , customerRepository , customerServiceConfig
@Configuration
public class CustomerServiceConfig {

	/*
	 * By Default Method Name : Bean ID			
	 */
	@Bean
	public CustomerRepository customerRepository() {
		return new ListCustomerRepositoryImpl();
	}
	
	@Bean
	public CustomerService customerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository());
		//customerService.setCustomerRepository(customerRepository());
		return customerService;
				
	}
}
