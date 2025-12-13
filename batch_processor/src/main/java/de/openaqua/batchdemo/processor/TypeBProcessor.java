package de.openaqua.batchdemo.processor;

import de.openaqua.batchdemo.domain.Customer;
import org.springframework.batch.item.ItemProcessor;

public class TypeBProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) {
        customer.setName(customer.getName().toLowerCase());
        customer.setEmail("B_" + customer.getEmail());
        return customer;
    }
}