package com.example.app1.dataStorage;

public class DataStorage {

    private static DataStorage instance;

    DataStorage(){}

    public static DataStorage getInstance() {
        if(instance == null)instance = new DataStorage();
        return instance;
    }




}
