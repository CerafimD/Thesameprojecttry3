package org.example.models;

public class City {
        String country;
        boolean is_capital;
        Object latitude;
        String name;
        Object longitude;
        int population;
    public City(String country,boolean is_capital,Object latitude,String name,Object longitude,int population){
        this.country = country;
        this.is_capital = is_capital;
        this.latitude = latitude;
        this.name = name;
        this.longitude = longitude;
        this.population = population;
    }

 }
