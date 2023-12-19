package org.example.models;

public record Salary(
        double salary_from,
        double salary_to,
        boolean salary_gross,
        Currency salary_currency
) {
    public static Salary parseSalary(String fromString, String toString, String grossString, String currencyString) {
        double from = Double.parseDouble(fromString);
        double to = Double.parseDouble(toString);
        boolean gross = Boolean.parseBoolean(grossString);
        Currency currency = Currency.valueOf(currencyString);
        return new Salary(from, to, gross, currency);
    }
}
