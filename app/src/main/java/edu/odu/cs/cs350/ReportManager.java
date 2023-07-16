package edu.odu.cs.cs350;


public class ReportManager {
    
public static String generateReport(String reportName) {

        System.out.println("Generating the report: " + reportName);
        return "Generated report: " + reportName;
    }
    
    public static String exportReport(String reportName, String format) {

        System.out.println("Exporting the report: " + reportName + " in format: " + format);
        return "Exported report: " + reportName + " in " + format + " format ";
    }
}

 