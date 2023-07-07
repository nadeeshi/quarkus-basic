package com.nadee.lil.quarkus.web.graphql;

import com.nadee.lil.quarkus.data.entity.Service;
import com.nadee.lil.quarkus.service.ServiceService;
import com.nadee.lil.quarkus.web.graphql.input.ServiceInput;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
public class ServiceResource {

    private final ServiceService serviceService;

    public ServiceResource(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @Query("allServices")
    @Description("Gets all services available in the system")
    public List<Service> getAllServices() {
        return this.serviceService.getAllServices();
    }

    @Mutation("addService")
    @Description("Adds a service to the system")
    public Service addService(ServiceInput serviceInput) {
        return this.serviceService.addService(serviceInput.getEntity());
    }

    @Query("getService")
    @Description("Gets an individual service by Id")
    public Service getService(@Name("id") long id) {
        return this.serviceService.getService(id);
    }

    @Mutation("updateService")
    @Description("Update an individual service")
    public Service updateService(Service service) {
        return this.serviceService.updateService(service);
    }

    @Mutation("deleteService")
    @Description("Deletes an individual service")
    public Service deleteService(@Name("id") long id) {
        Service service = this.serviceService.getService(id);
        this.serviceService.deleteService(id);

        return service;
    }
}
