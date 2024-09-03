package com.gst_reconciler.types;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
//make this class public
//Sheet as a class is a good concept
@Getter
@Setter
public class Sheet {
    private Map<Integer, Row> data;//[Ajay Opinion] - slight deviation from mental model, private List<SheetRow>

    //getters and setters are good
    //look and read about lombok apis
    public Sheet(Map<Integer, Row> data) {
        this.data = data;
    }

    public Map<Integer, Row> getData() {
        return data;
    }
    
    //should be in the sheet class
    //these operations should mostly not be static
    public void compareSheets(Sheet sheet1, Sheet sheet2) {
        Map<Integer, Row> rows1 = sheet1.getData();
        Map<Integer, Row> rows2 = sheet2.getData();

       
        for (Integer key : rows1.keySet()) {
            Row row1 = rows1.get(key);
            Row row2 = rows2.get(key);
            


            //one way to do this , is it right ?
            row1.compareRows( row2, key); 
        }
    }
}