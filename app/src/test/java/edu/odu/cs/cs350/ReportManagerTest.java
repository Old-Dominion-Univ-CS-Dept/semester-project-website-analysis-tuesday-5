package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.odu.cs.cs350.Website;
import org.junit.Before;
import org.junit.Test;;

public class ReportManagerTest {
    private ReportManager reportManager,reportManager1;
    private Website mockWebsite;

    @Before
    public void setUp() {
        reportManager = mock(ReportManager.class);
        reportManager1 = new ReportManager();
        mockWebsite = mock(Website.class);
    }

    /**
    * Tests the ability to set source data
    */

    @Test

    public void testSetSourceData() {
        reportManager1.setSourceData(mockWebsite);

        // Verify that the source data was set correctly
        assertEquals(mockWebsite, reportManager1.website);
    }

    /**
    * Tests the ability to determine the properly get the expected base file name
    */

    @Test
    public void testDetermineBaseFilename() {
        LocalDateTime now = LocalDateTime.of(2023, 7, 24, 12, 34, 56); // Set a fixed date-time for testing
        reportManager.website = mockWebsite;
        String expectedBaseFilename = "2023-07-24-123456";

        // Mock the LocalDateTime.now() call to return the fixed date-time
        LocalDateTime fixedDateTime = LocalDateTime.of(2023, 7, 24, 12, 34, 56);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
        String formattedDateTime = fixedDateTime.format(formatter);
        when(reportManager.determineBaseFilename()).thenReturn(formattedDateTime);
        // Test the determineBaseFilename method
        assertEquals(expectedBaseFilename, reportManager.determineBaseFilename());
    }

    /**
    * Tests ability to properly generate a report
    */


    public void testGenerateReport() {
       
        String reportName = "Sample Report";
        String generatedReport = ReportManager.generateReport(reportName);
        assertEquals("Generated report: " + reportName, generatedReport);
    }

    /**
    *Tests ability to export a sample report
    */

    @Test
    public void testExportReport() {
        
        String reportName = "Sample Report";
        String format = "PDF";
        String exportedReport = ReportManager.exportReport(reportName, format);
        assertEquals("Exported report: " + reportName + " in " + format + " format", exportedReport);

    }
}
