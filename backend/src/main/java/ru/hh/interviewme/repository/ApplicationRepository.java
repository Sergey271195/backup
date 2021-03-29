package ru.hh.interviewme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.hh.interviewme.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    
}
