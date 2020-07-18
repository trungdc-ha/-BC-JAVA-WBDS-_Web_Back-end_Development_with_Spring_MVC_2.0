package com.codegym.furama.service.impl;

import com.codegym.furama.entity.ServiceF;
import com.codegym.furama.repository.ServiceFRepository;
import com.codegym.furama.service.ServiceFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceFServiceImpl implements ServiceFService {

    @Autowired
    ServiceFRepository serviceFRepository;

    @Override
    public void addServiceF(ServiceF serviceF) {
        serviceFRepository.save(serviceF);
    }

    @Override
    public Page<ServiceF> getAllServiceF(Pageable pageable) {
        return serviceFRepository.findAll(pageable);
    }

    @Override
    public ServiceF getServiceFById(Long serviceFId) {
        return serviceFRepository.findById(serviceFId).orElse(null);
    }

    @Override
    public void editServiceF(ServiceF serviceF) {
        serviceFRepository.save(serviceF);
    }

    @Override
    public void deleteServiceF(Long serviceFId) {
        serviceFRepository.deleteById(serviceFId);
    }
}
