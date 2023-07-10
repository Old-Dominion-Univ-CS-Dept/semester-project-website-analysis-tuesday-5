package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class TextReportWriter {
    
    public static void writeReport(String fileName){
        try {
            BufferedWriter = new BufferedWriter(new FileWriter(filename));

            writer.write("Text report content.");

            writer.close();
            System.out.println("Report written successfully.");
    }   catch (IOException e) {
            System.err.println("Error writing the report: " + e.getMessage());
    }
    }
    
}