package org.example;

import org.example.Httprequests.HttpRequester;
import org.example.db.DBRepository;
import org.example.db.DBorm;
import org.example.db.VacancyEntity;
import org.example.db.mapper.vacancymapper;
import org.example.models.Vacancy;
import org.example.visualisation.drawer.BarDrawer;
import org.example.visualisation.drawer.PieChartDrawer;
import org.sqlite.core.DB;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

import java.io.IOException;
import java.util.List;


import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        List<Vacancy> vacancies = org.example.CSV.readVacancies("src/main/resources/vacancies.csv");
//        vacancies.forEach(vacancy -> {System.out.println(vacancy.toString());});
//
//
//        DBRepository.saveVacancies(vacancies);
//
//
        DBorm.connect();
        List<VacancyEntity> vacanciesENT = DBorm.getVacancies();
        List<Vacancy> vacancies = new ArrayList<>();
        vacanciesENT.forEach(vacancyEntity -> vacancies.add(vacancymapper.map(vacancyEntity)));

        DBorm.close();
        JPanel content = new JPanel(new BorderLayout(5,5));
        content.add(PieChartDrawer.createVacanciesByCity(vacancies),BorderLayout.SOUTH);
        content.add(BarDrawer.createSalaryByCity(vacancies),BorderLayout.NORTH);


        JFrame frame = new JFrame("JFreeChart demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
