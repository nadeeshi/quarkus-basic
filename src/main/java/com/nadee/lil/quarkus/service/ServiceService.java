package com.nadee.lil.quarkus.service;

import com.nadee.lil.quarkus.data.entity.Service;
import com.nadee.lil.quarkus.data.repository.ServiceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<Service> getAllServices() {
        return this.serviceRepository.listAll();
    }

    @Transactional
    public Service addService(Service service) {
        this.serviceRepository.persist(service);
        return service;
    }

    public Service getService(long id) {
        Service service = this.serviceRepository.findById(id);
        if (service == null) {
            throw new NotFoundException();
        }
        return service;
    }

    @Transactional
    public Service updateService(Service service) {

        Service entity = this.serviceRepository.findById(service.getId());
        if (entity == null) {
            throw new NotFoundException();
        }
        entity.setPrice(service.getPrice());
        entity.setName(service.getName());
        this.serviceRepository.persist(entity);
        return entity;
    }

    @Transactional
    public void deleteService(long id) {
        this.serviceRepository.deleteById(id);
    }
}
