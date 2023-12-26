package org.example.Httprequests;


import org.example.models.City;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HttpRequester {
    private static final String Translate_URL = "https://translate.api.cloud.yandex.net/translate/v2/translate";
    private static final String API_KEY = "O6A44yyitgjjDwipwD3faA==XYuydqr6U4te7t3Z";

    public static void getCityData(String areaName) throws IOException{
        String IAM_TOKEN = "t1.9euelZrGypnMnpyUipCYm8aRx8ySzu3rnpWajcmcnJeYz52bm4mWmI3Hz5Hl8_cLUl9T-e8-A1h1_t3z90sAXVP57z4DWHX-zef1656VmpKOiseRxpaZkZeQzZ6Lx57H7_zF656VmpKOiseRxpaZkZeQzZ6Lx57H.peqqCeKke1wODcETVuqjDHOHu06cwvcYvzUPHxqb2oM8OBtK1vLE33-9YiGQ9SNbTvWwhv9vllm842kO9ZqQAQ";
        String folder_id = "b1gqnlrrijrcq9nq27ng";
        String target_language = "ru";
        String[] texts = {"Hello", "World"};

        URL url = new URL(Translate_URL);
        HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
        connection.setRequestProperty("accept","application/json");
        connection.setRequestProperty("x-api-key",API_KEY);




    }
}
