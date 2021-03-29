package ru.hh.interviewme.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDto {

    public ApplicationDto() {}

    private int id;
    private UserDto user;
    private String status;
    private LocalDateTime date;
    private SkillDto skill;

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
    
    public SkillDto getSkill() {
        return skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ApplicationDto [id=" + id + 
            ", username=" + user.getName() + 
            ", useremail=" + user.getEmail() +
            ", skill=" + skill.getName() +
            ", date=" + date + 
            ", status=" + status + ']';
    }
}
