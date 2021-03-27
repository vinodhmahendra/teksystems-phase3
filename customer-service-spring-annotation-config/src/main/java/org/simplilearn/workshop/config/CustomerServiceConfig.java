package org.simplilearn.workshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan(basePackages = "org.simplilearn.workshop")
@ComponentScan(basePackages = "org.simplilearn.workshop.repository , org.simplilearn.workshop.service")
public class CustomerServiceConfig {

}
