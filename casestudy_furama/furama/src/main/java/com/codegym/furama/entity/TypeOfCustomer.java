package com.codegym.furama.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TypeOfCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeOfCustomerId;

    private String typeOfCustomerName;

    @OneToMany
    private List<Customer> customers;
}
