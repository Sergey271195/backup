package ru.hh.interviewme.service;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import ru.hh.interviewme.dao.ApplicationDao;
import ru.hh.interviewme.dto.ApplicationDto;
import ru.hh.interviewme.entity.Application;
import ru.hh.interviewme.entity.ApplicationStatus;
import ru.hh.interviewme.entity.Skill;
import ru.hh.interviewme.entity.User;
import ru.hh.interviewme.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationDao applicationDao;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApplicationService(ApplicationRepository applicationRepository, ApplicationDao applicationDao) {
        this.applicationRepository = applicationRepository;
        this.applicationDao = applicationDao;
        objectMapper.registerModule(new JavaTimeModule());
    }

    public Application createApplication(User user, Skill skill, LocalDateTime date) {
        Application application = new Application();
        application.setUser(user);
        application.setSkill(skill);
        application.setDate(date);
        application.setStatus(ApplicationStatus.PENDING);
        applicationRepository.save(application);
        return application;
    }

    public List<Application> getAllApplications() {
        return applicationDao.getAllEager();
    }

    public ApplicationDto getApplication(int id) throws NotFoundException {
        Application app = applicationDao.getEager(id).orElseThrow(NotFoundException::new);
        ApplicationDto dto = objectMapper.convertValue(app, ApplicationDto.class);
        return dto;
    }


}
