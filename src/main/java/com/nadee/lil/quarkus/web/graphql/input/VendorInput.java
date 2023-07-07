package com.nadee.lil.quarkus.web.graphql.input;

import com.nadee.lil.quarkus.data.entity.Vendor;

public class VendorInput {

    private String name;

    private String contact;

    private String email;

    private String phone;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public Vendor getEntity() {
        Vendor vendor = new Vendor();
        vendor.setName(this.name);
        vendor.setContact(this.contact);
        vendor.setPhone(this.phone);
        vendor.setEmail(this.email);
        vendor.setAddress(this.address);

        return vendor;
    }
}
