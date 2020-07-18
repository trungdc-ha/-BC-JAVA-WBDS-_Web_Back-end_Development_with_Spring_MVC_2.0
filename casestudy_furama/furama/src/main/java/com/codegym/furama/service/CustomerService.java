package com.codegym.furama.service;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.TypeOfCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void addCustomer(Customer customer);

    Page<Customer> getAllCustomer(Pageable pageable);

    Customer getCustomerById(Long customerId);

    void editCustomer(Customer customer);

    void deleteCustomer(Long customerId);

    Page<Customer> findByCustomerNameContaining(String username, Pageable pageable);

    Page<Customer> getAllCustomerByType(Long typeOfCustomer, Pageable pageable);
}
