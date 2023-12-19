package org.example.Httprequests;

public record City (
        String country,
        boolean is_capital,
        Object latitude,
        String name,
        Object longitude,
        int population

){ }
