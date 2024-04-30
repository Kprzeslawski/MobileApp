package com.example.app1.dataStorage;

import org.apache.http.client.HttpClient;

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
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.connect();
                    int responseCode = conn.getResponseCode();
                    System.out.println("RESPONSE CODE: "+ responseCode);
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
