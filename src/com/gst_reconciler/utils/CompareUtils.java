package com.gst_reconciler.utils;

import java.time.LocalDate;

public class CompareUtils {
    
    public static boolean compareStrings(String s1, String s2) {
    if (s1 == null || s2 == null) return false;
    if (s1.isEmpty() || s2.isEmpty()) return false; 

    int diffCount = 0;
    for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            diffCount++;
            if (diffCount > 2) return false;
        }
    }

    // If the strings are of different lengths, count the extra characters as differences
    diffCount += Math.abs(s1.length() - s2.length());

    return diffCount <= 2;
}


    public static boolean compareDates(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return false;}
        return Math.abs(date1.toEpochDay() - date2.toEpochDay()) <= 1;
    }
}
