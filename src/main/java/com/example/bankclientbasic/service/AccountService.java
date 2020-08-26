package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService implements GeneralService<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account obj) {
        return accountRepository.save(obj);
    }

    @Override
    public boolean delete(Account obj) {
        accountRepository.delete(obj);
        return true;
    }

    @Override
    public void deleteAll(List<Account> entities) {
        accountRepository.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
        accountRepository.saveAll(entities);
    }

    @Override
    public List<Account> getAll() {
        return (List<Account>)accountRepository.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        accountRepository.deleteById(id);
        return true;
    }

    @Override
    public Account getById(long id) {
        return accountRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public Account addSum(String accountNumber, Double sum) {
        Account account = accountRepository.findAccountsByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);
        Double currentBalance = account.getBalance();
        Double newBalance = currentBalance == null ? sum : (currentBalance + sum);
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

    public Account withdrawSum(String accountNumber, Double sum) {
        Account account = accountRepository.findAccountsByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);
        Double currentBalance = account.getBalance();

        if (currentBalance > sum) {
            Double newBalance = currentBalance - sum;
            account.setBalance(newBalance);
            return accountRepository.save(account);

        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void transferBetweenAccounts(String accountNumberFrom,
                                        String accountNumberTo,
                                        Double sum) {

        Account accountFrom = accountRepository.findAccountsByNumber(accountNumberFrom)
                .orElseThrow(RuntimeException::new);
        Account accountTo = accountRepository.findAccountsByNumber(accountNumberTo)
                .orElseThrow(RuntimeException::new);
        Double accountFromBalance = accountFrom.getBalance();
        Double accountToBalance = accountTo.getBalance();

        if (accountFromBalance > sum) {
            Double accountFromNewBalance = accountFromBalance - sum;
            Double accountToNewBalance = accountToBalance == null ? sum : (accountToBalance + sum);
            accountFrom.setBalance(accountFromNewBalance);
            accountTo.setBalance(accountToNewBalance);
            accountRepository.save(accountFrom);
            accountRepository.save(accountTo);

        } else {
            throw new RuntimeException();
        }
    }
}


