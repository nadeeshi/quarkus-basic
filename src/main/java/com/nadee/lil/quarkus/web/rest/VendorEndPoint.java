package com.nadee.lil.quarkus.web.rest;

import com.nadee.lil.quarkus.data.entity.Vendor;
import com.nadee.lil.quarkus.data.repository.VendorRepository;
import io.netty.util.internal.StringUtil;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.ArrayList;
import java.util.List;

@Path("/rest/vendors")
public class VendorEndPoint {

    private final VendorRepository vendorRepository;

    public VendorEndPoint(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @GET
    public List<Vendor> getVendors(@QueryParam("email") String email, @QueryParam("name") String name) {
        if (StringUtil.isNullOrEmpty(email) && StringUtil.isNullOrEmpty(name)) {
            return this.vendorRepository.listAll();
        } else {
            List<Vendor> vendors = new ArrayList<>();

            if (!StringUtil.isNullOrEmpty(email) && !StringUtil.isNullOrEmpty(name)) {
                Vendor vendor = this.vendorRepository.findByEmailAndName(email, name);
                vendors.add(vendor);
            } else if (!StringUtil.isNullOrEmpty(email)) {
                Vendor vendor = this.vendorRepository.findByEmail(email);
                vendors.add(vendor);
            } else {
                Vendor vendor = this.vendorRepository.findByName(name);
                vendors.add(vendor);
            }

            return vendors;
        }
    }
}
