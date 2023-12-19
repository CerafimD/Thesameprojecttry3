package org.example;

import org.example.Httprequests.HttpRequester;
import org.example.models.Vacancy;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try{
            HttpRequester.getCityData("Pervouralsk");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}