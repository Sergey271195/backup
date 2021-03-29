package ru.hh.interviewme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.hh.interviewme.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
