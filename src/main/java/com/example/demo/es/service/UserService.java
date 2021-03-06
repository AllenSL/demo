package com.example.demo.es.service;

import com.example.demo.es.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User findById(Long id);

    void deleteById(Long id);

    void delete(User user);

    List<User> findAll();
}
