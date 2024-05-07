package com.example.app1.dataStorage.dataTypes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Enemy {
    String name;
    Integer min_gold;
    Integer max_gold;
    Integer min_exp;
    Integer max_exp;
    Stats stats;
}
