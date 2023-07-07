package com.nadee.lil.quarkus.web.graphql.input;

import com.nadee.lil.quarkus.data.entity.Customer;

public class CustomerInput {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getEntity() {
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setPhone(this.phone);
        customer.setEmail(this.email);
        customer.setAddress(this.address);

        return customer;
    }
}
