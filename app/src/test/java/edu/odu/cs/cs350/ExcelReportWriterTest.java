package edu.odu.cs.cs350;

import edu.odu.cs.cs350.ExcelReportWriter;
import edu.odu.cs.cs350.Page;
import edu.odu.cs.cs350.Website;
import org.apache.poi.ss.usermodel.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExcelReportWriterTest {

    private Website testWebsite;

    @Before
    public void setUp() {
        // Create a Website object with some test data
        testWebsite = new Website();
        // Add test data to the website
        testWebsite.addPage(new Page("Page 1", "https://www.example.com/page1"));
        testWebsite.addPage(new Page("Page 2", "https://www.example.com/page2"));
    }

    @Test
    public void testWriteExcelReport() {
        // Set up the ExcelReportWriter
        ExcelReportWriter reportWriter = new ExcelReportWriter();
        reportWriter.setSourceData(testWebsite);

        // Specify a valid path for the test report file
        String reportFilePath = "path/to/test_report";
        reportWriter.setBaseName(reportFilePath);

        // Call the write method
        reportWriter.write();

        // Check if the report file was generated
        File reportFile = new File(reportFilePath + ".xlsx");
        assertTrue("Excel report file was not generated.", reportFile.exists());

        // Read the generated Excel file to verify its content
        try (FileInputStream fis = new FileInputStream(reportFile)) {
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Website Data");

            // Verify headers
            Row headerRow = sheet.getRow(0);
            assertEquals("Page Title", headerRow.getCell(0).getStringCellValue());
            assertEquals("Page URL", headerRow.getCell(1).getStringCellValue());

            // Verify data
            List<Page> pages = testWebsite.getPages();
            for (int i = 0; i < pages.size(); i++) {
                Row dataRow = sheet.getRow(i + 1);
                assertNotNull(dataRow);
                assertEquals(pages.get(i).getTitle(), dataRow.getCell(0).getStringCellValue());
                assertEquals(pages.get(i).getUrl(), dataRow.getCell(1).getStringCellValue());
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading Excel report: " + e.getMessage());
        }

        // Clean up: delete the generated report file after the test
        reportFile.delete();
    }

    @Test
    public void testWriteExcelReportWithNoData() {
        // Set up the ExcelReportWriter with no source data
        ExcelReportWriter reportWriter = new ExcelReportWriter();
        reportWriter.setSourceData(null);

        // Specify a valid path for the test report file
        String reportFilePath = "path/to/test_report";
        reportWriter.setBaseName(reportFilePath);

        // Call the write method
        reportWriter.write();

        // Check if the report file was generated
        File reportFile = new File(reportFilePath + ".xlsx");
        assertFalse("Excel report file should not have been generated with no source data.", reportFile.exists());
    }
}

