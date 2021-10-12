package com.mastek.pizzania.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastek.pizzania.dao.PizzaniaDao;
import com.mastek.pizzania.model.Pizzania;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PizzaniaController {

	@Autowired
	PizzaniaDao pizzaniaDao;
	
	@GetMapping("/")
	public String getMessage() {
		return "hello";
	}
	@GetMapping("/pizza-details")
	public List<Pizzania> findAllPizza(){
		return pizzaniaDao.findAll();
	}
	
	@GetMapping("/pizza-details/{id}")
	public Pizzania getPizzaByPid(@PathVariable (value="id") int id) {
		Optional<Pizzania> optional=pizzaniaDao.findById(id);
		if(optional.isPresent()) {
				return optional.get();
		}
			return null;
	}
}