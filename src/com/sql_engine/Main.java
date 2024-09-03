package com.sql_engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Map<String, Integer>> rows = new ArrayList<>();
        
        Map<String, Integer> row1 = new HashMap<>();
        row1.put("Ajay", 100);
        rows.add(row1);
        
        Map<String, Integer> row2 = new HashMap<>();
        row2.put("Ajay", 200);
        rows.add(row2);
        
        Map<String, Integer> row3 = new HashMap<>();
        row3.put("Nikhil", 500);
        rows.add(row3);
        
        Map<String, Integer> row4 = new HashMap<>();
        row4.put("Nikhil", 25);
        rows.add(row4);
        
        SQLEngine sqlEngine = new SQLEngine(new GroupBySumStrategy());
        
        System.out.println("Group By Sum:");
        sqlEngine.groupBy(rows);
        
        System.out.println("----------");
        
        sqlEngine.setGroupByStrategy(new GroupByMaxStrategy());
        
        System.out.println("Group By Max:");
        sqlEngine.groupBy(rows);
    }
}
