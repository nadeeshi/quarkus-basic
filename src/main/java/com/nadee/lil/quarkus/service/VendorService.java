package com.nadee.lil.quarkus.service;

import com.nadee.lil.quarkus.data.entity.Vendor;
import com.nadee.lil.quarkus.data.repository.VendorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getAllVendors() {
        return this.vendorRepository.listAll();
    }

    public List<Vendor> getVendorsByName(String name) {
        Vendor vendor = this.vendorRepository.findByName(name);
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        return vendors;
    }

    public List<Vendor> getVendorsByEmail(String email) {
        Vendor vendor = this.vendorRepository.findByEmail(email);
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        return vendors;
    }

    public List<Vendor> getVendorsByEmailAndName(String email, String name) {
        Vendor vendor = this.vendorRepository.findByEmailAndName(email, name);
        List<Vendor> vendors = new ArrayList<>();
        vendors.add(vendor);
        return vendors;
    }

    @Transactional
    public Vendor addVendor(Vendor vendor) {
        this.vendorRepository.persist(vendor);
        return vendor;
    }

    public Vendor getVendor(long id) {
        Vendor vendor = this.vendorRepository.findById(id);
        if (vendor == null) {
            throw new NotFoundException();
        }
        return vendor;
    }

    @Transactional
    public Vendor updateVendor(Vendor vendor) {
        Vendor entity = this.vendorRepository.findById(vendor.getId());
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setAddress(vendor.getAddress());
        entity.setContact(vendor.getContact());
        entity.setEmail(vendor.getEmail());
        entity.setName(vendor.getName());
        entity.setPhone(vendor.getPhone());

        this.vendorRepository.persist(vendor);
        return entity;
    }

    @Transactional
    public void deleteVendor(long id) {
        this.vendorRepository.deleteById(id);
    }
}
