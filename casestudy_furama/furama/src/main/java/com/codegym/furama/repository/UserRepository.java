package com.codegym.furama.repository;

import com.codegym.furama.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByAccount(String account);
}