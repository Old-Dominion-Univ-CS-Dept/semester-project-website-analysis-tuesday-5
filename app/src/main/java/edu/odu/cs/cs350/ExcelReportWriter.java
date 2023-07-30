package edu.odu.cs.cs350;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class ExcelReportWriter<Row> {
    private Website sourceData;
    private String baseName;

    public void setSourceData(Website website) {
        this.sourceData = website;
        
    }
    public void setBaseName(String baseFilename) {
        this.baseName = baseFilename; 
    }

    public void write() {
        if (sourceData == null || baseName == null) {
            System.err.println("Error: Source data or base filename not set.");
            return;
        }

        if (baseName == null || baseName.isEmpty()) {
            System.err.println("Base filename not provided. Please set the source data using setSourceData() method.");
            return;
        }

try (FileOutputStream outputStream = new FileOutputStream(baseName + ".xlsx")) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Website Data");

            List<Page> pages = sourceData.getPages();

            int rowIdx = 0;

            // Writing headers for the Excel report
            Row headerRow = sheet.createRow(rowIdx++);
            headerRow.createCell(0).setCellValue("Page Title");
            headerRow.createCell(1).setCellValue("Page URL");

            // Writing data for each page
            for (Page page : pages) {
                Row dataRow = sheet.createRow(rowIdx++);
                dataRow.createCell(0).setCellValue(page.getTitle());
                dataRow.createCell(1).setCellValue(page.getUrl());
            }

            workbook.write(outputStream);
            workbook.close();

            System.out.println("Excel report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error writing Excel report: " + e.getMessage());
        }
    }
}