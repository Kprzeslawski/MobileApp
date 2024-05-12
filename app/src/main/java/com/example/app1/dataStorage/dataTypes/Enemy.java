package com.example.app1.dataStorage.dataTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enemy {
    String name;
    Integer min_gold;
    Integer max_gold;
    Integer min_exp;
    Integer max_exp;
    Stats stats;
}
