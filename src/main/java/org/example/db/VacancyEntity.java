package org.example.db;

import com.j256.ormlite.field.DatabaseField;
import org.example.models.Experience;
import org.example.models.Salary;
import org.example.models.Vacancy;

import java.time.LocalDateTime;
import java.util.Set;

public class VacancyEntity {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String description;

    @DatabaseField
    private boolean premium;
    @DatabaseField
    private String employerName;
    @DatabaseField
    private double salary;
    @DatabaseField
    private String areaName;

    public VacancyEntity(){}
    public VacancyEntity(String name, String description, boolean premium, String employerName, double salary, String areaName) {
        this.name=name;
        this.description = description;

        this.premium = premium;
        this.employerName = employerName;
        this.salary = salary;
        this.areaName = areaName;

    }
    @Override
    public String toString(){
        return String.format("name:%s; description:%s; employerName:%s;",name,description,employerName);
    }

}
