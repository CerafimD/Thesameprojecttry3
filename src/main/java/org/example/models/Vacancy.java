package org.example.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Vacancy{
    String name;
    String description;
    Set<String> keySkills;
    Experience experience;
    boolean premium;
    String employerName;
    Salary salary;
    String areaName;
    LocalDateTime publishedAt;

    public Vacancy(String name, String description, Set<String> keySkills, Experience experience, boolean premium, String employerName, Salary salary, String areaName, LocalDateTime publishedAt) {
        this.name=name;
        this.description = description;
        this.keySkills = keySkills;
        this.experience = experience;
        this.premium = premium;
        this.employerName = employerName;
        this.salary = salary;
        this.areaName = areaName;
        this.publishedAt = publishedAt;
    }

    public String getName() {
        return name;
    }
    public String getAreaName(){
        return areaName;
    }
    public String getDescription(){return description;}
    public Set<String> getKeySkills(){return keySkills;}
    public Experience getExperience(){return experience;}
    public boolean isPremium(){return premium;}
    public String getEmployerName(){return employerName;}
    public double getSalary(){return (salary.to+salary.from)/2;}
    public LocalDateTime getPublishedAt(){return publishedAt;}


    @Override
    public String toString(){
        String keySkillsJoined = String.join(",", keySkills);
        return String.format("name:%s; description:%s; KeySkills:%s;",name,description,keySkillsJoined);
    }

}