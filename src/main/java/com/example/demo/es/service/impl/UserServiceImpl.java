package com.example.demo.es.service.impl;

import com.example.demo.es.entity.User;
import com.example.demo.es.repository.UserEsRepository;
import com.example.demo.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEsRepository userEsRepository;

    @Override
    public User create(User user) {
        if (null == user) {
            return null;
        }
        System.out.println(userEsRepository);
        return userEsRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        if (null == id) {
            return null;
        }
        Optional<User> byId = userEsRepository.findById(id);
        User user = byId.get();
        return null;
    }

    @Override
    public List<User> findAll() {
        final List<User> users = new ArrayList<User>();
        userEsRepository.findAll().forEach(item -> {
            users.add(item);
        });
        return users;
    }

    @Override
    public void deleteById(Long id) {
        userEsRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userEsRepository.delete(user);
    }
}
