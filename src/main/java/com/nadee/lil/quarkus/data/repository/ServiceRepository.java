package com.nadee.lil.quarkus.data.repository;

import com.nadee.lil.quarkus.data.entity.Service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ServiceRepository {

    private final EntityManager entityManager;

    public ServiceRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Service> getAllServices() {
        List<Service> services = this.entityManager.createQuery("select service from Service service", Service.class).getResultList();

        return services;
    }
}
