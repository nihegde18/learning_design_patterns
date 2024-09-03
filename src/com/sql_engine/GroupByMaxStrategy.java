package com.sql_engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByMaxStrategy implements GroupByStrategy {
    @Override
    public void groupBy(List<Map<String, Integer>> rows) {
        Map<String, Integer> result = new HashMap<>();
        

        // Output the result
        result.forEach((name, maxAmount) -> {
            System.out.println(name + " - " + maxAmount);
        });
    }
}
