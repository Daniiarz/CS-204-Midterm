package com.example.customerList.repository;

import com.example.customerList.model.Admin;
import com.example.customerList.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {
    List<Admin> findByUsername(String username);
}
