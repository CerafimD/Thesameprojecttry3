package org.example.Httprequests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.City;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class HttpRequester {
    private static final String CITIES_URL = "https://api.api-ninjas.com/v1/city?name=";
    private static final String API_KEY = "O6A44yyitgjjDwipwD3faA==XYuydqr6U4te7t3Z";

    public static void getCityData(String areaName) throws IOException{
        URL url = new URL(CITIES_URL+areaName);
        HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
        connection.setRequestProperty("accept","application/json");
        connection.setRequestProperty("x-api-key",API_KEY);
        InputStream response = connection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
       /// City[] cities = mapper.readValue(response,City[].class);
        JsonNode root = mapper.readTree(response);
        System.out.println(root.path("fact").asText());

    }
}
