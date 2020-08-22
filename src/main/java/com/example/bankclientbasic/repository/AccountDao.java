package com.example.bankclientbasic.repository;

import com.example.bankclientbasic.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class AccountDao implements GeneralDao<Account> {

    @Autowired
    private EntityManager em;

    @Override
    public Account save(Account obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    public boolean delete(Account obj) {
        em.remove(obj);
        return true;
    }

    @Override
    public void deleteAll(List<Account> entities) {
        entities.forEach(a -> deleteById(a.getId()));
    }

    @Override
    public void saveAll(List<Account> entities) {
        entities.forEach(a -> save(a));
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> namedQuery = em.createNamedQuery("Account.getAll", Account.class);
        return namedQuery.getResultList();
    }

    @Override
    public boolean deleteById(long id) {
        em.remove(getOne(id));
        return true;
    }

    @Override
    public Account getOne(long id) {
        return em.find(Account.class, id);
    }

    public Account updateExisting(Account account) {
        em.merge(account);
        return account;
    }
}


