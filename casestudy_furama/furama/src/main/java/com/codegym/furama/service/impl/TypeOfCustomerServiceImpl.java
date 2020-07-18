package com.codegym.furama.service.impl;

import com.codegym.furama.entity.TypeOfCustomer;
import com.codegym.furama.repository.TypeOfCustomerRepository;
import com.codegym.furama.service.TypeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfCustomerServiceImpl implements TypeOfCustomerService {

    @Autowired
    TypeOfCustomerRepository typeOfCustomerRepository;

    @Override
    public List<TypeOfCustomer> getAllTypeOfCustomer() {
        return typeOfCustomerRepository.findAll();
    }

    @Override
    public Page<TypeOfCustomer> getAllTypeOfCustomerPage(Pageable pageable) {
        return typeOfCustomerRepository.findAll(pageable);
    }
}
