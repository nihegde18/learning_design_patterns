package com.sql_engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByMaxStrategy implements GroupByStrategy {
    @Override
    public void groupBy(List<Map<String, Integer>> rows) {
        Map<String, Integer> result = new HashMap<>();
        
        for (Map<String, Integer> row : rows) {
            for (String key : row.keySet()) {
                int value = row.get(key);
                
                if (result.containsKey(key)) {
                    if (value > result.get(key)) {
                        result.put(key, value);
                    }
                } else {
                    result.put(key, value);
                }
            }
        }
    
        // Output the result
        for (String key : result.keySet()) {
            System.out.println(key + " - " + result.get(key));
        }
    }
}
