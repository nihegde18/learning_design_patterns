package com.gst_reconciler.types;

import java.time.LocalDate;

import com.gst_reconciler.utils.CompareUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Row {
    private LocalDate date;
    private String senderGSTIN; // Changed to camelCase
    private String receiverGSTIN; // Changed to camelCase
    private String productCode; // Changed to camelCase
    private float price; // Changed to camelCase
    private float gst; // Changed to camelCase

    public Row(LocalDate date, String senderGSTIN, String receiverGSTIN, String productCode, float price, float gst) {
        this.date = date;
        this.senderGSTIN = senderGSTIN;
        this.receiverGSTIN = receiverGSTIN;
        this.productCode = productCode;
        this.price = price;
        this.gst = gst;
    }
    //Use static if the method doesn’t rely on instance-specific data (i.e., it doesn’t need to access non-static fields or methods of the class).
    //Suitable if you want to compare rows without needing an instance of the Row class.
    // Method to compare rows
    public void compareRows( Row row2, int rowIndex) {
        boolean discrepancyFound = false;

        if (!CompareUtils.compareDates(this.getDate(), row2.getDate())) {
            logError("Date mismatch at row " + rowIndex, this, row2);
            discrepancyFound = true;
        }
        if (!CompareUtils.compareStrings(this.getSenderGSTIN(), row2.getSenderGSTIN())) {
            logError("Sender GSTIN mismatch at row " + rowIndex, this, row2);
            discrepancyFound = true;
        }
        if (!CompareUtils.compareStrings(this.getReceiverGSTIN(), row2.getReceiverGSTIN())) {
            logError("Receiver GSTIN mismatch at row " + rowIndex, this, row2);
            discrepancyFound = true;
        }
        if (!CompareUtils.compareStrings(this.getProductCode(), row2.getProductCode())) {
            logError("Product Code mismatch at row " + rowIndex, this, row2);
            discrepancyFound = true;
        }
        if (Math.abs(this.getPrice() - row2.getPrice()) > 10) {
            logError("Price mismatch at row " + rowIndex, this, row2);
            discrepancyFound = true;
        }
        if (Math.abs(this.getGst() - row2.getGst()) > 10) {
            logError("GST mismatch at row " + rowIndex, this, row2);
            discrepancyFound = true;
        }

        if (!discrepancyFound) {
            System.out.println("Row " + rowIndex + " matches between the sheets.");
        }
    }
    //should this be static ?
    private static void logError(String message, Row row1, Row row2) {
        System.out.println(message);
        System.out.println("Row in sheet1: " + row1);
        System.out.println("Row in sheet2: " + row2);
    }
}
