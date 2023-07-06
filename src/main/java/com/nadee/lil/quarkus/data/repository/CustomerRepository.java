package com.nadee.lil.quarkus.data.repository;

import com.nadee.lil.quarkus.data.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public Customer findByEmail(String email) {
        return find("email", email).firstResult();
    }
}
