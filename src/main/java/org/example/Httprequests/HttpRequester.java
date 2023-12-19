package org.example.Httprequests;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequester {
    private static final String CITIES_URL = "https://api.api-ninjas.com/v1/city?name=";

    public static void getCityData(String areaName) throws IOException{
        URL url = new URL(CITIES_URL+areaName);
        HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
        connection.setRequestProperty("accpet","application/json");
        InputStream response = connection.getInputStream();

    }
}
