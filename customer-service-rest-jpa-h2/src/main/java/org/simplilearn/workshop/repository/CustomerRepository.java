package org.simplilearn.workshop.repository;

import org.simplilearn.workshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
}
