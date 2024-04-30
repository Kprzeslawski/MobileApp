package com.example.app1.dataStorage;

import lombok.Data;

public class DataStorage {

    private static DataStorage instance;

    DataStorage(){}

    public static DataStorage getInstance() {
        if(instance == null)instance = new DataStorage();
        return instance;
    }

    private String data;


}
