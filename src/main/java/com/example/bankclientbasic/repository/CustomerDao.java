package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CustomerDao implements GeneralDao<Customer> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer save(Customer obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        em.remove(obj);
        return true;
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        entities.forEach(c -> deleteById(c.getId()));
    }

    @Override
    public void saveAll(List<Customer> entities) {
        entities.forEach(c -> save(c));
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.getAll", Customer.class);
        return namedQuery.getResultList();
    }

    @Override
    public boolean deleteById(long id) {
        em.remove(getOne(id));
        return true;
    }

    @Override
    public Customer getOne(long id) {
        return em.find(Customer.class, id);
    }

    public Customer updateExisting(Customer customer) {
        em.merge(customer);
        return customer;
    }
}


