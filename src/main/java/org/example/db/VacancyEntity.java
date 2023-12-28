package org.example.db;

import com.j256.ormlite.field.DatabaseField;
import org.example.models.Currency;
import org.example.models.Experience;
import org.example.models.Salary;
import org.example.models.Vacancy;

import java.time.LocalDateTime;
import java.util.Date;
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
    @DatabaseField
    private Date publishedAt;


    public VacancyEntity(){}
    public VacancyEntity(String name, String description, boolean premium, String employerName, double salary, String areaName,
    Date publishedAt) {
        this.name=name;
        this.description = description;

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
    public boolean isPremium(){return premium;}
    public String getEmployerName(){return employerName;}
    public Salary getSalary(){return new Salary(salary,salary,false,Currency.RUR);}

    public Date getPublishedAt(){  return publishedAt;}

    @Override
    public String toString() {
        return "VacancyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", premium=" + premium +
                ", employerName='" + employerName + '\'' +
                ", salary=" + salary +
                ", areaName='" + areaName + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }
}
