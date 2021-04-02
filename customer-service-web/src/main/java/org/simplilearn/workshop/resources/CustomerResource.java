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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path="/customers", produces = "application/json")
	public List<Customer> retrieveAllCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/list")
	public ModelAndView listCustomers(Model theModel) {
		
		ModelAndView model = new ModelAndView("list-customers");
				
		// add the customers to the model
		model.addObject("customers",retrieveAllCustomers());
		
		return model;
	}
	
	
	@GetMapping("/showFormForAdd")
	public ModelAndView showFormForAdd(Model theModel) {
		ModelAndView model = new ModelAndView("customer-form");
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		model.addObject("customer", theCustomer);
		
		return model;
	}
	
	@PostMapping("/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		ModelAndView model = new ModelAndView("redirect:/list");
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		return model;
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

	
	@GetMapping("/showFormForUpdate")
	public ModelAndView showFormForUpdate(@RequestParam("customerId") Integer theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = retreveCustomer(theId).getContent();	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return new ModelAndView("customer-form");
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
