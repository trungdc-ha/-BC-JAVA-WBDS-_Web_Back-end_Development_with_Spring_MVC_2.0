package com.codegym.furama.service.impl;

import com.codegym.furama.entity.TypeOfServiceF;
import com.codegym.furama.repository.TypeOfServiceFRepository;
import com.codegym.furama.service.TypeOfServiceFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfServiceFServiceFImpl implements TypeOfServiceFService {

    @Autowired
    TypeOfServiceFRepository typeOfServiceFRepository;

    @Override
    public List<TypeOfServiceF> getAllTypeOfServiceF() {
        return typeOfServiceFRepository.findAll();
    }
}
