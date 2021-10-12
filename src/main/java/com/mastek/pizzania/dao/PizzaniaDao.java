package com.mastek.pizzania.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastek.pizzania.model.Pizzania;

@Repository
public interface PizzaniaDao extends JpaRepository<Pizzania, Integer>{

}