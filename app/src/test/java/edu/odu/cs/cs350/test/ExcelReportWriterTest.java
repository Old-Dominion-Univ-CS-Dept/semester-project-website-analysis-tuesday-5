package edu.odu.cs.cs350.test;

import edu.odu.cs.cs350.ExcelReportWriter;
import edu.odu.cs.cs350.Website;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class ExcelReportWriterTest {

    @Test
    public void testWriteExcelReport() {
        // Create a Website object with some test data
        Website testWebsite = new Website(null, null, null);       // Add test data to the website, e.g., testWebsite.addPage(...)

        // Set up the ExcelReportWriter
        ExcelReportWriter reportWriter = new ExcelReportWriter();
        reportWriter.setSourceData(testWebsite);
        reportWriter.setBaseName("test_report");

        // Call the write method
        reportWriter.write();

        // Check if the report file was generated
        File reportFile = new File("test_report.xlsx");
        assertTrue("Excel report file was not generated.", reportFile.exists());

        // TODO: Add more specific assertions to check the content of the Excel report,
        // such as reading the file and verifying the data matches the expected data.
        // You can use Apache POI or other libraries to read the Excel file and perform the assertions.

        // Clean up: delete the generated report file after the test
        reportFile.delete();
    }
}





    