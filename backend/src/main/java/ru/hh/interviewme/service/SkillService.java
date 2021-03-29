package ru.hh.interviewme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.hh.interviewme.entity.Skill;
import ru.hh.interviewme.repository.SkillRepository;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkill(int id) {
        return skillRepository.getOne(id);
    }

}
