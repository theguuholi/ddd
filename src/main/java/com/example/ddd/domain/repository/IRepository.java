package com.example.ddd.domain.repository;

import java.util.List;

interface IRepository<T> {
    void create(T entity);

    void update(T entity);

    T find(String id);

    List<T> findAll();
}
