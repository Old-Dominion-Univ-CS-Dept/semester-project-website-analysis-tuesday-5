package edu.odu.cs.cs350;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReportManagerTest {

    @Before
    public void setUp() {
        
    }

    @Test
    public void testGenerateReport() {
        String reportName = "Sample Report";
        
        // Call the method under test
        ReportManager.generateReport(reportName);
        
        // Perform assertions to validate the behavior
        assertTrue(//what is report testing//(reportName));
    }

    @Test
    public void testExportReport() {
        String reportName = "Sample Report";
        String format = "PDF";
        
        // Call the method under test
        ReportManager.exportReport(reportName, format);
        
        // Perform assertions to validate the behavior
        assertTrue(// ask group (reportName, format));
    }
}

// added comment
// added new comment