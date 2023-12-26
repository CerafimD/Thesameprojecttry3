package org.example;

import org.example.Httprequests.HttpRequester;
import org.example.db.DBRepository;
import org.example.db.DBorm;
import org.example.db.VacancyEntity;
import org.example.models.Vacancy;
import org.sqlite.core.DB;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import java.io.IOException;


import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

public class Main {
    public static void main(String[] args) throws Exception {
       // List<Vacancy> vacancies = org.example.CSV.readVacancies("src/main/resources/vacancies.csv");
        //vacancies.forEach(vacancy -> {System.out.println(vacancy.toString());});
        //System.out.println(vacancies.get(0).toString());
        //DBorm.connect();
      //  DBorm.createTable();
   //     for (var vacancy : vacancies) {
     //       DBorm.saveVacancies(vacancy);
  //      }
   //     DBorm.close();

        DBorm.connect();
        List<VacancyEntity> vacancies = DBorm.getVacancies();
        vacancies.forEach(vacancy -> {System.out.println(vacancy.toString());});
        DBorm.close();
    }
}
