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
        String generatedReport = ReportManager.generateReport(reportName);
        assertEquals("Generated report: " + reportName, generatedReport);
    }

    @Test
    public void testExportReport() {
        
        String reportName = "Sample Report";
        String format = "PDF";
        String exportedReport = ReportManager.exportReport(reportName, format);
        assertEquals("Exported report: " + reportName + " in " + format + " format", exportedReport);
}
}