package com.nadee.lil.quarkus.service;

import com.nadee.lil.quarkus.data.entity.Customer;
import com.nadee.lil.quarkus.data.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.listAll();
    }

    public List<Customer> getCustomersByEmail(String email) {
        Customer customer = this.customerRepository.findByEmail(email);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        return customers;
    }

    @Transactional
    public Customer addCustomer(Customer customer) {
        this.customerRepository.persist(customer);
        return customer;
    }

    public Customer getCustomer(long id) {
        Customer customer = this.customerRepository.findById(id);
        if (customer == null) {
            throw new NotFoundException();
        }
        return customer;
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        Customer entity = this.customerRepository.findById(customer.getId());
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setAddress(customer.getAddress());
        entity.setEmail(customer.getEmail());
        entity.setFirstName(customer.getFirstName());
        entity.setPhone(customer.getPhone());
        entity.setLastName(customer.getLastName());
        this.customerRepository.persist(entity);
        return entity;
    }

    @Transactional
    public void deleteCustomer(long id) {
        this.customerRepository.deleteById(id);
    }
}
