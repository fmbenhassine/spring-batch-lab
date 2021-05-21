package com.example.demo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

}
