package com.wanubit.security.service.impl;

import com.wanubit.security.domain.User;
import com.wanubit.security.repository.UserRepository;
import com.wanubit.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUserService implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public Optional<User> retrieve(Long id) {
        return repository.findById(id);
    }
}
