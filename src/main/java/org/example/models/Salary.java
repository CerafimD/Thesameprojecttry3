package org.example.models;

public class Salary{
    double from;
    double to;
    boolean gross;
    Currency currency;

    public Salary(double from, double to, boolean gross, Currency currency) {
        this.from = from;
        this.to = to;
        this.gross = gross;
        this.currency = currency;
    }


}
