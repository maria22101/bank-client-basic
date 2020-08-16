package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerDao implements GeneralDao<Customer>{

    List<Customer> storage = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Customer save(Customer obj) {
        obj.setId(counter.incrementAndGet());
        storage.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        if (storage.contains(obj)) {
            storage.remove(obj);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        if (storage.isEmpty()) {
            return;
        }
        storage.removeAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        storage.addAll(entities);
    }

    @Override
    public List<Customer> findAll() {
        return storage;
    }

    @Override
    public boolean deleteById(long id) {
        Customer customerToRemove = getOne(id);
        if(customerToRemove == null) {
            return false;
        }
        storage.remove(customerToRemove);
        return true;
    }

    @Override
    public Customer getOne(long id) {
        Optional<Customer> customer = storage
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        return customer.orElse(null);
    }

    public Customer updateExisting(Customer customer) {
        Optional<Customer> customerToUpdate = storage
                .stream()
                .filter(c -> c.getId().equals(customer.getId()))
                .findFirst();

        customerToUpdate.ifPresent(c -> storage.set(storage.indexOf(c), customer));
        return customer;
    }
}
