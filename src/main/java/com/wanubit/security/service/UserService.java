package com.wanubit.security.service;

import com.wanubit.security.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> list();
    Optional<User> retrieve(Long id);
}
