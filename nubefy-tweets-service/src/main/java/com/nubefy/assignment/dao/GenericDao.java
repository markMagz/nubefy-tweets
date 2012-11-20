package com.nubefy.assignment.dao;

import java.util.List;

public interface GenericDao<T, PK> {

    void create(T entity);

    T get(PK id);

    List<T> getAll();

}
