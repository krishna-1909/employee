package com.offerpad.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.offerpad.service.CustomerService;
import com.offerpad.userEntity.Customer;
import com.offerpad.exception.CustomException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {
        if (hasSpecialCharacters(customer)) {
            throw new CustomException("INVALID_DATA: Special characters are not allowed.");
        }
        Customer savedCustomer = customerService.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer created with ID: " + savedCustomer.getCustomerId());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            throw new CustomException("NOT_FOUND: No customer found with ID: " + id);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@Valid @RequestBody Customer customer) {
        if (hasSpecialCharacters(customer)) {
            throw new CustomException("INVALID_DATA: Special characters are not allowed.");
        }
        Customer updatedCustomer = customerService.update(customer);
        if (updatedCustomer != null) {
            return ResponseEntity.ok("Customer updated with ID: " + updatedCustomer.getCustomerId());
        } else {
            throw new CustomException("NOT_FOUND: No customer found with ID: " + customer.getCustomerId());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Method to check for special characters
    private boolean hasSpecialCharacters(Customer customer) {
        String pattern = "[!@#$%^&*()]";
        return Pattern.compile(pattern).matcher(customer.getCustomerName()).find() ||
               Pattern.compile(pattern).matcher(customer.getDescription()).find() ||
               Pattern.compile(pattern).matcher(customer.getMemo()).find() ||
               Pattern.compile(pattern).matcher(customer.getCustomerType()).find() ||
               Pattern.compile(pattern).matcher(customer.getCustomerAgentName()).find() ||
               Pattern.compile(pattern).matcher(customer.getCustomerAgentId()).find() ||
               Pattern.compile(pattern).matcher(customer.getCustomeDocumentName()).find();
    }
}
