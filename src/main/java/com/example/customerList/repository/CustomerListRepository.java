package com.example.customerList.repository;

import com.example.customerList.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerListRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstNameAndLastName(String firstName, String LastName);
}
