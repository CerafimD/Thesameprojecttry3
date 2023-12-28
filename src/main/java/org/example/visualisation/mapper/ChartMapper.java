package org.example.visualisation.mapper;

import jdk.jfr.Category;
import org.example.models.Vacancy;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChartMapper {
    public static PieDataset createPieDataVacancies(List<Vacancy> vacancies){
        Map<String,Long> vacanciesByCity= vacancies.stream()
                .collect(
                        Collectors.groupingBy(
                                Vacancy::getAreaName,
                                Collectors.counting()
                        )
                ).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(20).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        DefaultPieDataset dataset = new DefaultPieDataset();
        vacanciesByCity.forEach(dataset::setValue);
        return dataset;
    }
    public static CategoryDataset createBarSalaryByCity(List<Vacancy> vacancies){
        Map<String,Double> salaryByCity= vacancies.stream()
                .collect(
                        Collectors.groupingBy(
                                Vacancy::getAreaName,
                                Collectors.averagingDouble(Vacancy::getSalary)
                        )
                ).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(25)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        salaryByCity.forEach((v,k) -> dataset.setValue(k,"Salary",v));
        return dataset;
    }
}

