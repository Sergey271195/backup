package ru.hh.interviewme.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        if (entity != null) {
            entityManager.persist(entity);
        }
    }

    public Optional<T> getById(Serializable id) {
        T entity = entityManager.find(clazz, id);
        return entity == null ? Optional.empty() : Optional.of(entity);
    }

    public List<T> getAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void delete(T entity) {
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public Optional<T> update (T entity) {
        if (entity != null) {
            return Optional.of(entityManager.merge(entity));
        }
        return Optional.empty();
    }
    
    
}
