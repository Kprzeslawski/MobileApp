package com.example.app1.dataStorage.dataTypes;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponse {
    private String id;
    private String name;
    private String slot;
    private Map<String,Integer> stats;
}
