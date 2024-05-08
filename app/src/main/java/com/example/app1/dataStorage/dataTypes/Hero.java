package com.example.app1.dataStorage.dataTypes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hero {
 Stats stats;
 List<ItemResponse> equipped;
}
