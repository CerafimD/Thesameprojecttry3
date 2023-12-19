package org.example;

import org.example.models.Vacancy;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Vacancy> vacancies = org.example.CSV.readVacancies("src/main/resources/vacancies.csv");
        HashSet<String> allAreas =  new HashSet<>() ;
        vacancies.forEach((vacancy -> {
            allAreas.add(vacancy.getAreaName());
        }));
        System.out.println(allAreas);
    }
}