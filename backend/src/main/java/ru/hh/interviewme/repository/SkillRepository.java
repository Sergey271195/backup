package ru.hh.interviewme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.hh.interviewme.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    
}
