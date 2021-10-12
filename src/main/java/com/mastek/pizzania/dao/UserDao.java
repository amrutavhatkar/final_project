package com.mastek.pizzania.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastek.pizzania.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);
}
