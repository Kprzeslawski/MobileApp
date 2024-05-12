package com.example.app1.dataStorage;

import android.app.Activity;

import com.example.app1.dataStorage.dataTypes.Enemy;
import com.example.app1.dataStorage.dataTypes.InventoryResponse;
import com.example.app1.dataStorage.dataTypes.Location;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.function.Consumer;

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

    public static void fetchLocations(Consumer<Location> callback, Activity thread_f){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(baseConnection + "/player/locations");
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

                        ObjectMapper objectMapper = new ObjectMapper();
                        List<Location> locationList = objectMapper.readValue(response.toString(), new TypeReference<List<Location>>() {});

                        thread_f.runOnUiThread( new Runnable(){
                            @Override
                            public void run(){
                                locationList.forEach(callback);
                            }
                        });
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

    public static void fetchLocationEnemies(String locName,Consumer<Enemy> callback, Activity thread_f){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(baseConnection + "/location_enemies/" + locName);
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

                        ObjectMapper objectMapper = new ObjectMapper();
                        List<Enemy> enemyList = objectMapper.readValue(response.toString(), new TypeReference<List<Enemy>>() {});

                        thread_f.runOnUiThread( new Runnable(){
                            @Override
                            public void run(){
                                enemyList.forEach(callback);
                            }
                        });
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

    public static void fetchPlayerInventory(String playerId){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(baseConnection + "/player/player_inventory/" + playerId);
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

                        ObjectMapper objectMapper = new ObjectMapper();
                        InventoryResponse playerInventory = objectMapper.readValue(response.toString(), InventoryResponse.class);
                        System.out.println("GOLD: " + playerInventory.getGold());
                        System.out.println("N_ITEMS: " + playerInventory.getItems().size());
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
}
