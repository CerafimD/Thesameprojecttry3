package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.example.models.Experience;
import org.example.models.Salary;
import org.example.models.Vacancy;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class CSV {


    public static List<Vacancy> readVacancies(String filePath) {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withSkipLines(1).build()) {
            return csvReader
                    .readAll()
                    .stream()
                    .map(CSV::parseVacancy)
                    .toList();
        } catch (IOException | CsvException exception) {
            throw new RuntimeException(exception);
        }
    }
    public static Vacancy parseVacancy(String[] fields) {
        return new Vacancy(
                fields[0],
                parseDescription(fields[1]),
                parseKeySkills(fields[2]),
                Experience.parseExperience(fields[3]),
                Boolean.parseBoolean(fields[4]),
                fields[5],
                Salary.parseSalary(fields[6], fields[7], fields[8], fields[9]),
                fields[10],
                parsePublishedAt(fields[11])
        );
    }

    private static String parseDescription(String description) {
        return description
                .replaceAll("<[^<>]*>", "")
                .replaceAll("\\s+", " ")
                .strip();
    }

    private static Set<String> parseKeySkills(String keySkillsString) {
        return Arrays.stream(keySkillsString.split("\n")).collect(Collectors.toSet());
    }

    private static LocalDateTime parsePublishedAt(String publishedAtString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        return LocalDateTime.parse(publishedAtString, formatter);
    }
}
