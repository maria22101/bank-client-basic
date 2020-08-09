package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AccountDao implements GeneralDao<Account> {

    List<Account> storage = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Account save(Account obj) {
        obj.setId(counter.incrementAndGet());
        storage.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Account obj) {
        if (storage.contains(obj)) {
            storage.remove(obj);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Account> entities) {
        if (storage.isEmpty()) {
            return;
        }
        storage.removeAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
        storage.addAll(entities);
    }

    @Override
    public List<Account> findAll() {
        return storage;
    }

    @Override
    public boolean deleteById(long id) {
        Account accountToRemove = getOne(id);
        if(accountToRemove == null) {
            return false;
        }
        storage.remove(accountToRemove);
        return true;
    }

    @Override
    public Account getOne(long id) {
        Optional<Account> account = storage
                .stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        return account.orElse(null);
    }

    public Account updateExisting(Account account) {
        Optional<Account> accountToUpdate = storage
                .stream()
                .filter(a -> a.getId().equals(account.getId()))
                .findFirst();

        accountToUpdate.ifPresent(a -> storage.set(storage.indexOf(a), account));
        return account;
    }
}
