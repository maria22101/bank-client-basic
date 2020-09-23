package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findAccountsByNumber(String number);
}



