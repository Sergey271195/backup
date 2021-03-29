package ru.hh.interviewme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import ru.hh.interviewme.entity.Skill;
import ru.hh.interviewme.repository.SkillRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class InterviewmeApplicationTests extends TestContainerBase {

    @Autowired
    public SkillRepository skillRepository;

    @Test
    public void testSkillsAreSaved() {
        Skill skill_1 = new Skill();
        skill_1.setName("Java");
        skillRepository.save(skill_1);

        Skill skill_2 = new Skill();
        skill_2.setName("Python");
        skillRepository.save(skill_2);

        Skill skill_3 = new Skill();
        skill_3.setName("Go");
        skillRepository.save(skill_3);

        Skill skill_4 = new Skill();
        skill_4.setName("SQL");
        skillRepository.save(skill_4);

        List<Skill> skills = skillRepository.findAll();
        skills.stream().forEach(System.out::println);
        assertEquals(4, skills.size());
    }

}
