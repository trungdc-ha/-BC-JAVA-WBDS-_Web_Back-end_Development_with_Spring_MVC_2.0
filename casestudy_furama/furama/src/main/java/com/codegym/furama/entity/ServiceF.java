package com.codegym.furama.entity;

import com.codegym.furama.service.TypeOfCustomerService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ServiceF implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;

    private double area;

    private double rentCost;

    private int numberOfPeople;

    @OneToOne
    private TypeOfServiceF typeOfServiceF;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
