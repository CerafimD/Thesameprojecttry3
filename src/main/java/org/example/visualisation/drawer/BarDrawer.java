package org.example.visualisation.drawer;

import org.example.models.Vacancy;
import org.example.visualisation.mapper.ChartMapper;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.util.List;

public class BarDrawer extends JFrame {
    public BarDrawer(String title, List<Vacancy> vacancies){
        super(title);
        setContentPane(createSalaryByCity(vacancies));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(500,500);
    }
    public static JPanel createSalaryByCity(List<Vacancy> vacancies){
        JFreeChart chart =  createBarChart(ChartMapper.createBarSalaryByCity(vacancies));
        chart.setPadding(new RectangleInsets(4,8,2,2));
        return new ChartPanel(chart);
    }

    private static JFreeChart createBarChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                 "Salary By City",
                "City Name",
                "Salary",
                dataset,
                PlotOrientation.HORIZONTAL,
                false,
                false,
                false
        );
        return chart;
    }

}
