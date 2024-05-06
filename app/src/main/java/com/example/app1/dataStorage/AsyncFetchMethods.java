package com.example.app1.dataStorage;

import org.apache.http.client.HttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncFetchMethods {

    public static final String baseConnection = "http://192.168.137.1:8080/api";
    public static void fetchTest(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(baseConnection + "/player/test");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();

                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();

                        String jsonResponse = response.toString();

                        System.out.println("DATA: " + jsonResponse);
                    } else {
                        System.out.println("Failed to fetch data. Status code: " + responseCode);
                    }
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    String sampleApiRequest() throws Exception {
        HttpClient client;
//        H
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://jsonplaceholder.typicode.com/todos"))
//                .build();
//
//        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//
//        return response.body();
        return null;
    }
}
