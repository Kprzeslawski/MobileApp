package com.example.app1.dataStorage;

import lombok.Data;

@Data
public class DataStorage {

    private static DataStorage instance;

    DataStorage(){
        playerId = "662d7b1cc10854687a9ea740";
        heroId = "66412955a4f9eb2051ec8f74";
    }

    public static DataStorage getInstance() {
        if(instance == null)instance = new DataStorage();
        return instance;
    }

    private String playerId;
    private String heroId;


}
