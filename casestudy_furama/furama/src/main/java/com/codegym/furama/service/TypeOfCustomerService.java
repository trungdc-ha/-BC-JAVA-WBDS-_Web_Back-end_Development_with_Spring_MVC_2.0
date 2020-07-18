package com.codegym.furama.service;

import com.codegym.furama.entity.TypeOfCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeOfCustomerService {
    List<TypeOfCustomer> getAllTypeOfCustomer();

    Page<TypeOfCustomer> getAllTypeOfCustomerPage(Pageable pageable);
}
