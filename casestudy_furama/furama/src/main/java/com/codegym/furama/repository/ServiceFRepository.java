package com.codegym.furama.repository;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.ServiceF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceFRepository extends JpaRepository<ServiceF, Long> {
}
