package com.nadee.lil.quarkus.data.repository;

import com.nadee.lil.quarkus.data.entity.Service;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import org.jboss.resteasy.reactive.ResponseStatus;

import java.util.List;

@ApplicationScoped
public class ServiceRepository implements PanacheRepository<Service> {

    // private final EntityManager entityManager;

    private final ServiceRepository serviceRepository;

    public ServiceRepository(ServiceRepository serviceRepository) {
        //this.entityManager = entityManager;
        this.serviceRepository = serviceRepository;
    }

    @GET
    public List<Service> getAllServices() {
        // List<Service> services = this.entityManager.createQuery("select service from Service service", Service.class).getResultList();

        return this.serviceRepository.listAll();
    }

    @POST
    @ResponseStatus(201)
    @Transactional
    public Service addService(Service service) {
        this.serviceRepository.persist(service);

        return service;
    }
}
