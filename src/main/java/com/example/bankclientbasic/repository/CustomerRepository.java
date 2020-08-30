package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findCustomersByNameAndEmail(String name, String email);
}
