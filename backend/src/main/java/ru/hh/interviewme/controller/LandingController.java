package ru.hh.interviewme.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.hh.interviewme.dto.ApplicationDto;
import ru.hh.interviewme.entity.Application;
import ru.hh.interviewme.entity.Skill;
import ru.hh.interviewme.entity.User;
import ru.hh.interviewme.request.SignupRequestModel;
import ru.hh.interviewme.service.ApplicationService;
import ru.hh.interviewme.service.SkillService;
import ru.hh.interviewme.service.UserService;

@RestController
@RequestMapping("/landing")
public class LandingController {

    private final SkillService skillService;
    private final UserService userService;
    private final ApplicationService applicationService;

    public LandingController(ru.hh.interviewme.service.SkillService skillService, UserService userService,
            ApplicationService applicationService) {
        this.skillService = skillService;
        this.userService = userService;
        this.applicationService = applicationService;
    }

    @GetMapping(path = "/skills")
    public List<Skill> getAvailableSkills() {
        return skillService.getSkills();
    }

    @PostMapping(path = "/application")
    public ApplicationDto postApplication(@RequestBody SignupRequestModel request) throws NotFoundException {
        Skill chosenSkill = skillService.getSkill(request.getSkillId());
        User newUser = userService.saveUser(request.getName(), request.getPhone(), request.getEmail());
        Application createdApplication = applicationService.createApplication(newUser, chosenSkill, request.getDate());
        return applicationService.getApplication(createdApplication.getId());
    }

    @GetMapping(path = "/applications")
    public List<Application> getApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping(path = "/application/{id}")
    public ApplicationDto getApplications(@PathVariable("id") int id) throws NotFoundException {
        return applicationService.getApplication(id);
    }

}
