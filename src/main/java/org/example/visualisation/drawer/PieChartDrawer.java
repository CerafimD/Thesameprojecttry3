package org.example.visualisation.drawer;

import org.example.models.Vacancy;
import org.example.visualisation.mapper.ChartMapper;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.util.List;

public class PieChartDrawer extends JFrame {
    public PieChartDrawer(String title, List<Vacancy> vacancies){
        super(title);
        setContentPane(createVacanciesByCity(vacancies));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(500,500);

    }
    public static JPanel createVacanciesByCity(List<Vacancy>vacancies){
        JFreeChart chart = createPieChart(ChartMapper.createPieDataVacancies(vacancies));
        chart.setPadding(new RectangleInsets(4,8,2,2));
        chart.setAntiAlias(true);

        return new ChartPanel(chart);
    }
    public static JFreeChart createPieChart(PieDataset dataset){

        JFreeChart chart = ChartFactory.createPieChart(
                "Vacancies by city",
                dataset,
                false,
                true,
                false
        );


        return chart;
    }
}
