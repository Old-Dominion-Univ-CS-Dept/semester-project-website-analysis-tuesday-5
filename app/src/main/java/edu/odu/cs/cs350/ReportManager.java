package edu.odu.cs.cs350;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
* Report Manager class
*/

public class ReportManager {

    Website website;

    /** 
    * Set Source data function
    @param website
    */
    
    public void setSourceData(Website website){
        this.website = website;
    };

    /** 
    * Determine base file name function
    @return now.format(formatter)
    */

    public String determineBaseFilename() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
        return now.format(formatter);
    }

    /**
    * Write all data for parent functions 
    */

    public void writeAll() {
        String baseFilename = determineBaseFilename();

        // Create instances of each ReportWriter derived class
        TextReportWriter textReportWriter = new TextReportWriter();
        textReportWriter.setSourceData(website);

        JSONReportWriter jsonReportWriter = new JSONReportWriter();
        jsonReportWriter.setSourceData(website);

        ExcelReportWriter excelReportWriter = new ExcelReportWriter();
        excelReportWriter.setSourceData(website);

        // Call the write method for each ReportWriter
        textReportWriter.setBaseName(baseFilename);
        textReportWriter.write();

        jsonReportWriter.setBaseName(baseFilename);
        jsonReportWriter.write();

        excelReportWriter.setBaseName(baseFilename);
        excelReportWriter.write();
    } 

    /**
    * Generates reports with data
    @param reportName
    @return "Generated report: " + reportName;
*/
    
public static String generateReport(String reportName) {

        System.out.println("Generating the report: " + reportName);
        return "Generated report: " + reportName;
    }

    /** 
    * Exports report with data
    @param reportName
    @param format
    @return "Exported report: " + reportName + " in " + format + " format "
    */
    
    public static String exportReport(String reportName, String format) {

        System.out.println("Exporting the report: " + reportName + " in format: " + format);
        return "Exported report: " + reportName + " in " + format + " format ";

    }
}
