package com.example.app1.dataStorage;

import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncFetchMethods {

    public static void fetchTest(){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.137.1:8080/api/player/test");
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
}
