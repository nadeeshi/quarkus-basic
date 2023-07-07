package com.nadee.lil.quarkus.data.repository;

import com.nadee.lil.quarkus.data.entity.Vendor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VendorRepository implements PanacheRepository<Vendor> {

    public Vendor findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public Vendor findByName(String name) {
        return find("lower(name)", name.toLowerCase()).firstResult();
    }

    public Vendor findByEmailAndName(String email, String name) {
        return find("lower(name) = :name and email = :email ",
                Parameters.with("name", name.toLowerCase()).and("email", email)).firstResult();
    }
}
