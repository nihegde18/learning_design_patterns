package com.sql_engine;

import java.util.List;
import java.util.Map;

public interface GroupByStrategy {
    void groupBy(List<Map<String, Integer>> rows);
}
