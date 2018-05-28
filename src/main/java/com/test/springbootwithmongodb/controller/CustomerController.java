package com.test.springbootwithmongodb.controller;

import com.test.springbootwithmongodb.entity.Customer;
import com.test.springbootwithmongodb.repo.CustomerRepository;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Customers")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/list")
    public List<Customer> listAll(@RequestBody Customer customer) {
        Example<Customer> example = Example.of(customer);
        return repository.findAll(example);
    }

    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/delete")
    public List<Customer> delete(@RequestBody Customer customer) {
        repository.delete(customer);

        return listAll(customer);
    }

}
