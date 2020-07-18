package com.codegym.furama.repository;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.TypeOfCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByCustomerNameContaining(String username, Pageable pageable);
    Page<Customer> findByTypeOfCustomer_TypeOfCustomerId(Long typeOfCustomer, Pageable pageable);
}
