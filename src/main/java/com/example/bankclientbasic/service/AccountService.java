package com.example.bankclientbasic.service;

import com.example.bankclientbasic.model.Account;
import com.example.bankclientbasic.model.Customer;
import com.example.bankclientbasic.repository.AccountDao;
import com.example.bankclientbasic.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements GeneralService<Account> {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account save(Account obj) {
        return accountDao.save(obj);
    }

    @Override
    public boolean delete(Account obj) {
        return accountDao.delete(obj);
    }

    @Override
    public void deleteAll(List<Account> entities) {
        accountDao.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
        accountDao.saveAll(entities);
    }

    @Override
    public List<Account> getAll() {
        return accountDao.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        return accountDao.deleteById(id);
    }

    @Override
    public Account getById(long id) {
        return accountDao.getOne(id);
    }

    public Account addSum(String accountNumber, Double sum) {
        Account account = getAccountByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);
        Double newBalance = account.getBalance() + sum;
        account.setBalance(newBalance);
        return accountDao.updateExisting(account);
    }

    public Account withdrawSum(String accountNumber, Double sum) {
        Account account = getAccountByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);
        Double currentBalance = account.getBalance();

        if (currentBalance > sum) {
            Double newBalance = currentBalance - sum;
            account.setBalance(newBalance);
            return accountDao.updateExisting(account);

        } else {
            throw new RuntimeException();
        }
    }

    public void transferBetweenAccounts(String accountNumberFrom,
                                        String accountNumberTo,
                                        Double sum) {

        Account accountFrom = getAccountByNumber(accountNumberFrom)
                .orElseThrow(RuntimeException::new);
        Account accountTo = getAccountByNumber(accountNumberTo)
                .orElseThrow(RuntimeException::new);
        Double accountFromBalance = accountFrom.getBalance();
        Double accountToBalance = accountTo.getBalance();

        if (accountFromBalance > sum) {
            accountFrom.setBalance(accountFromBalance - sum);
            accountTo.setBalance(accountToBalance + sum);
            accountDao.updateExisting(accountFrom);
            accountDao.updateExisting(accountTo);

        } else {
            throw new RuntimeException();
        }
    }

    private Optional<Account> getAccountByNumber(String accountNumber) {
        return accountDao.findAll()
                .stream()
                .filter(a -> a.getNumber().equals(accountNumber))
                .findFirst();
    }
}

