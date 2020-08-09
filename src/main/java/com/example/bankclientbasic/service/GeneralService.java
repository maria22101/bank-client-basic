package com.example.bankclientbasic.service;

import java.util.List;

public interface GeneralService<T> {

    T save(T obj);

    boolean delete(T obj);

    void deleteAll(List<T> entities);

    void saveAll(List<T> entities);

    List<T> getAll();

    boolean deleteById(long id);

    T getById(long id);
}
