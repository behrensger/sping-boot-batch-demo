package de.openaqua.batchdemo.processor;

import de.openaqua.batchdemo.domain.Customer;
import org.springframework.batch.item.ItemProcessor;

public class TypeAProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) {
        customer.setName(customer.getName().toUpperCase());
        customer.setEmail("A_" + customer.getEmail());
        return customer;
    }
}