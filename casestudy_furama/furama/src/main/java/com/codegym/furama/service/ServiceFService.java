package com.codegym.furama.service;

import com.codegym.furama.entity.ServiceF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceFService {
    void addServiceF(ServiceF serviceF);

    Page<ServiceF> getAllServiceF(Pageable pageable);

    ServiceF getServiceFById(Long serviceFId);

    void editServiceF(ServiceF serviceF);

    void deleteServiceF(Long serviceFId);
}
