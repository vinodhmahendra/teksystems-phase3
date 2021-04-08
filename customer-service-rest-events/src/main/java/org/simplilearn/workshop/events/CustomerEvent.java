package org.simplilearn.workshop.events;

import org.simplilearn.workshop.model.Customer;
import org.springframework.context.ApplicationEvent;

public class CustomerEvent extends ApplicationEvent {

	private String event_type;
	private Customer customer;
	
	public CustomerEvent(Object source,String event_type,Customer customer) {
		super(source);
		this.event_type = event_type;
		this.customer = customer;
	}

	public String getEvent_type() {
		return event_type;
	}
	
	public Customer getCustomer() {
		return customer;
	}
}
