package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.*;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public List<Customer> findByName(String name) ;
	public Optional<Customer> findById(Integer id);
	

	
}
