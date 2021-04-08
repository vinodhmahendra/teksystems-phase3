package org.simplilearn.workshop.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventsProccessor implements ApplicationListener<CustomerEvent> {

	@Override
	public void onApplicationEvent(CustomerEvent event) {
		System.out.println("Customer " + event.getEvent_type() + " with details :" +event.getCustomer());
	}

}
