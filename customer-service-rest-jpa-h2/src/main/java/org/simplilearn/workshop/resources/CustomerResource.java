package org.simplilearn.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.simplilearn.workshop.exceptions.CustomerNotFoundException;
import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;

	
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers(){
		return customerService.getCustomers();
	}
	
	// GET /customers/{theId}
	@GetMapping("/customers/{theId}")
	public Customer retrieveCustomer(@PathVariable Integer theId) {
		Customer customer = customerService.getCustomer(theId);
		if (customer == null) {
			throw new CustomerNotFoundException("id-" + theId);
		}
		return customer;
	}
	
	//input - details of customer
	//output - CREATED & Return the created URI
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer theCustomer){
		Customer savedCustomer = customerService.saveCustomer(theCustomer);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{theId}")
				.buildAndExpand(savedCustomer.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer theId) {
		customerService.deleteCustomer(theId);
	}
	
	@PutMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCutomer(@PathVariable Integer theId,@RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.getCustomer(theId);
		
		if (savedCustomer == null) {
			throw new CustomerNotFoundException("id = " + theId);
		}else {
			savedCustomer.setId(theId);
			savedCustomer.setFirstName(theCustomer.getFirstName());
			savedCustomer.setLastName(theCustomer.getLastName());
			savedCustomer.setEmail(theCustomer.getEmail());
			customerService.saveCustomer(savedCustomer);
		}
	}
}
