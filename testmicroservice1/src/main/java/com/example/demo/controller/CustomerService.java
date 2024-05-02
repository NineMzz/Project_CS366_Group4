package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> searchByName(String name) {
        return repo.findByName(name);
    }

    public Optional<Customer> searchById(Integer id) {
        return repo.findById(id);
    }

    public Customer save(Customer customer) {
    	return repo.save(customer);
    }
  

}
