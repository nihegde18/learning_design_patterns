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
