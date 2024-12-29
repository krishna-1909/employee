package com.offerpad.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.offerpad.userEntity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
