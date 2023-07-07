package com.nadee.lil.quarkus.web.graphql;

import com.nadee.lil.quarkus.data.entity.Vendor;
import com.nadee.lil.quarkus.service.VendorService;
import com.nadee.lil.quarkus.web.graphql.input.VendorInput;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
public class VendorResource {

    private final VendorService vendorService;

    public VendorResource(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @Query("allVendors")
    @Description("Gets all vendors from the system")
    public List<Vendor> getAllVendors() {
        return this.vendorService.getAllVendors();
    }

    @Query("vendorsByEmail")
    @Description("Gets all vendors from the system based on email address")
    public List<Vendor> getVendorsByEmail(@Name("email") String email) {
        return this.vendorService.getVendorsByEmail(email);
    }

    @Query("vendorsByName")
    @Description("Gets all vendors from the system based on name")
    public List<Vendor> getVendorsByName(@Name("name") String name) {
        return this.vendorService.getVendorsByName(name);
    }

    @Query("vendorsByNameAndEmail")
    @Description("Gets all vendors from the system based on name and email address")
    public List<Vendor> getVendorsByNameAndEmail(@Name("name") String name, @Name("email") String email) {
        return this.vendorService.getVendorsByEmailAndName(email, name);
    }

    @Mutation("addVendor")
    @Description("Adds a vendor to the system")
    public Vendor addVendor(VendorInput vendor) {
        return this.vendorService.addVendor(vendor.getEntity());
    }

    @Mutation("updateVendor")
    @Description("Update a vendor to the system")
    public Vendor updateVendor(Vendor vendor) {
        return this.vendorService.updateVendor(vendor);
    }

    @Mutation("deleteVendor")
    @Description("Deletes a vendor from the system")
    public Vendor deleteVendor(@Name("id") long id) {
        Vendor vendor = this.vendorService.getVendor(id);
        this.vendorService.deleteVendor(id);

        return vendor;
    }
}
