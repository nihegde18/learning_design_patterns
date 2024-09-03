package com.sql_engine;

import java.util.List;
import java.util.Map;

public class SQLEngine {
    
    private GroupByStrategy groupByStrategy;

    public SQLEngine(GroupByStrategy groupByStrategy) {
        this.groupByStrategy = groupByStrategy; 
    }

    public void setGroupByStrategy(GroupByStrategy groupByStrategy) {
        this.groupByStrategy = groupByStrategy; 
    }

    public void groupBy(List<Map<String, Integer>> rows) {
        groupByStrategy.groupBy(rows);
    }
}
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