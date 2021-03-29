package ru.hh.interviewme.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupRequestModel {

    private String name;
    private String email;
    private String phone;
    @JsonProperty("skill_id")
    private int skillId;
    private LocalDateTime date;
    
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSkillId() {
        return skillId;
    }
    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SignupRequest: [name=" + name + 
            ", email=" + email + 
            ", phone=" + phone + 
            ", skillId=" + skillId + 
            ", date=" + date + ']';
    }
    
}
