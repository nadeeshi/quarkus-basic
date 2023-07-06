package com.nadee.lil.quarkus.data.repository;

import com.nadee.lil.quarkus.data.entity.Vendor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VendorRepository implements PanacheRepository<Vendor> {

    public Vendor findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public Vendor findByName(String name) {
        return find("lower(name)", name.toLowerCase()).firstResult();
    }
}
