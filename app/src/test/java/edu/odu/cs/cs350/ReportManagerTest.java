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
        ReportManager.generateReport(reportName);
        
    }

    @Test
    public void testExportReport() {
        
        String reportName = "Sample Report";
        String format = "PDF";
        ReportManager.exportReport(reportName, format);
       
}
}