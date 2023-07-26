package edu.odu.cs.cs350;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReportManager {

    Website website;
    private List<ReportWriter> reportWriters;
    public void setSourceData(Website website){
        this.website = website;
    };

    public String determineBaseFilename() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
        return now.format(formatter);
    }

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
    
public static String generateReport(String reportName) {

        System.out.println("Generating the report: " + reportName);
        return "Generated report: " + reportName;
    }
    
    public static String exportReport(String reportName, String format) {

        System.out.println("Exporting the report: " + reportName + " in format: " + format);
        return "Exported report: " + reportName + " in " + format + " format ";

    }
}
