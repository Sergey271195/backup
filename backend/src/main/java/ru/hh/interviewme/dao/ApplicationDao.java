package ru.hh.interviewme.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ru.hh.interviewme.entity.Application;

@Repository
public class ApplicationDao extends GenericDao<ApplicationDao> {

    public ApplicationDao() {
        super(ApplicationDao.class);
    }

    public Optional<Application> getEager(int id) {
        try {
            return Optional.of(
                entityManager
                    .createQuery(
                        "SELECT a from Application a "+
                        "join fetch a.skill s " + 
                        "join fetch a.user u " +
                        "where a.id = :id", Application.class
                    ).setParameter("id", id).getSingleResult()
            );
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    public List<Application> getAllEager() {
        TypedQuery<Application> query = 
            entityManager
                .createQuery(
                    "select a from Application a "+
                    "left join fetch a.skill s " + 
                    "left join fetch a.user u", Application.class
                );
            return query.getResultList();
    }

}
