package org.simplilearn.workshop.resources;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.simplilearn.workshop.execeptions.CustomerNotFoundException;
import org.simplilearn.workshop.model.Customer;
import org.simplilearn.workshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	

	

	@GetMapping("/customers/{theId}")
	public EntityModel<Customer> retreveCustomer(@PathVariable Integer theId) {
		Customer customer = customerService.getCustomer(theId);
		if  (customer == null) {
			throw new CustomerNotFoundException("id - " + theId);
		}
		
		EntityModel<Customer> resource = EntityModel.of(customer);
		
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllCustomers());
		
		resource.add(linkTo.withRel("all-customers"));
		return resource;
	}

	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer){
		Customer savedCustomer = customerService.saveCustomer(customer);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{theId}")
				.buildAndExpand(savedCustomer.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void deleteCustomer(@PathVariable Integer theId) {
		customerService.deleteCustomer(theId);
		
	}
	
	@PutMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void updateCustomer(@RequestBody Customer customer,@PathVariable Integer theId) {
		Customer updateCustomer = customerService.getCustomer(theId);
		if (updateCustomer == null) {
			throw new CustomerNotFoundException("id - " + theId);
		}else {
			updateCustomer.setId(updateCustomer.getId());
			updateCustomer.setFirstName(customer.getFirstName());
			updateCustomer.setLastName(customer.getLastName());
			updateCustomer.setEmail(customer.getEmail());
			customerService.saveCustomer(updateCustomer);
		}
		
	}

}
