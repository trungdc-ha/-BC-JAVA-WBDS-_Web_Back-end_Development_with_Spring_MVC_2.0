package com.codegym.furama.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TypeOfServiceF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeOfServiceFId;

    private String typeOfServiceFName;

    @OneToMany
    private List<ServiceF> serviceFs;
}
