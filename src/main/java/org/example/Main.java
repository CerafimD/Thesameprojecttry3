package org.example;

import org.example.models.Vacancy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vacancy> vacancies = org.example.CSV.readVacancies("src/main/resources/vacancies.csv");
        System.out.println(vacancies);
    }
}