package com.nadee.lil.quarkus.web.graphql;

import com.nadee.lil.quarkus.data.entity.Customer;
import com.nadee.lil.quarkus.service.CustomerService;
import com.nadee.lil.quarkus.web.graphql.input.CustomerInput;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Query("allCustomers")
    @Description("Gets all customers from the system")
    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @Query("getCustomersByEmail")
    @Description("Gets customers that match a given email address")
    public List<Customer> getCustomersByEmail(@Name("email") String email) {
        return this.customerService.getCustomersByEmail(email);
    }

    @Query("getCustomer")
    @Description("Gets a single customer from the system")
    public Customer getCustomer(@Name("id") long id) {
        return this.customerService.getCustomer(id);
    }

    @Mutation("addCustomer")
    @Description("Adds a customer to the system")
    public Customer addCustomer(CustomerInput customer) {
        return this.customerService.addCustomer(customer.getEntity());
    }

    @Mutation("updateCustomer")
    @Description("Update a customer to the system")
    public Customer updateCustomer(Customer customer) {
        return this.customerService.updateCustomer(customer);
    }

    @Mutation("deleteCustomer")
    @Description("Deletes a customer from the system")
    public Customer deleteCustomer(@Name("id") long id) {
        Customer customer = this.customerService.getCustomer(id);
        this.customerService.deleteCustomer(id);

        return customer;
    }
}
