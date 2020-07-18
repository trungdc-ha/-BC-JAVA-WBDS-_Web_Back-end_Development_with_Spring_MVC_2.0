package com.codegym.furama.service.impl;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.TypeOfCustomer;
import com.codegym.furama.repository.CustomerRepository;
import com.codegym.furama.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Page<Customer> findByCustomerNameContaining(String username, Pageable pageable) {
        return customerRepository.findByCustomerNameContaining(username, pageable);
    }

    @Override
    public Page<Customer> getAllCustomerByType(Long typeOfCustomer, Pageable pageable) {
        return customerRepository.findByTypeOfCustomer_TypeOfCustomerId(typeOfCustomer, pageable);
    }
}
