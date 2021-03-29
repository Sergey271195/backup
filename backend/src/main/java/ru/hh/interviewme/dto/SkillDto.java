package ru.hh.interviewme.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SkillDto {

    @JsonIgnore
    private int id;
    
    private String name;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
}
