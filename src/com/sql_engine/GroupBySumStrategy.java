package com.sql_engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
// Next Problem
//Given a set of rows implement a basic SQL engine in java to support groupBy and Summation, Max //aggregation
/*Name Amount
Ajay 100
Ajay 200
Nikhil 500
Nikhil 25
    

groupby - Name, Sum(Amount) 
    
Ajay - 300
Nikhil - 525
    

groupby - Name, Max(Amount) 
    
Ajay - 200
Nikhil - 500*/ 
public class GroupBySumStrategy implements GroupByStrategy {
    @Override
    public void groupBy(List<Map<String, Integer>> rows) {
        Map<String, Integer> result = new HashMap<>();
        
        for (Map<String, Integer> row : rows) {
            for (String key : row.keySet()) {
                int value = row.get(key);
                
                if (result.containsKey(key)) {
                    result.put(key, result.get(key) + value);
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
