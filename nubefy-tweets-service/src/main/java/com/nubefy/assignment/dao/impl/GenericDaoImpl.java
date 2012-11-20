package com.nubefy.assignment.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.nubefy.assignment.dao.GenericDao;

public class GenericDaoImpl<T, PK> implements GenericDao<T, PK> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> persistentClass;

    public GenericDaoImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    @Transactional
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T get(PK id) {
        return entityManager.find(persistentClass, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return entityManager.createQuery("from " + persistentClass.getName()).getResultList();
    }

}
