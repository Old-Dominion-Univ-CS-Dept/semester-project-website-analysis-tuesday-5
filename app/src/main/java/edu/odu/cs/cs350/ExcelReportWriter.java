package edu.odu.cs.cs350;

<<<<<<< HEAD
import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.enums.Locality;
import edu.odu.cs.cs350.enums.ResourceKind;
import edu.odu.cs.cs350.Anchor;
import edu.odu.cs.cs350.Resource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
=======
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;


public class ExcelReportWriter<Row> {
    private Website sourceData;
    private String baseName;
>>>>>>> b9e28fa88b0b03e389c43c55e466b7c37ad16a41

public class ExcelReportWriter implements ReportWriter {
    private Website website;
    private String baseFileName;
    @Override
    public void setSourceData(Website website) {
<<<<<<< HEAD
        this.website = website;
    }

    @Override
    public void setBaseName(String baseFileName) {
        this.baseFileName = baseFileName+"-summary";

    }

    @Override
    public Website getWebsite() {
        return website;
    }

    @Override
    public String getBaseFileName() {
        return baseFileName;
    }

    @Override
    public void write() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(baseFileName);

        // Create the header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Page", "# Images", "# CSS", "Scripts", "# Links (Intra-Page)", "# Links (Internal)", "# Links (External)"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        List<HTMLDocument> pages = website.getPages();
        for (int i = 0; i < pages.size(); i++) {
            HTMLDocument page = pages.get(i);
            Row dataRow = sheet.createRow(i + 1);

            // Set the values for each column in the data row
            dataRow.createCell(0).setCellValue(page.getFileName().toString());
            dataRow.createCell(1).setCellValue(getResourceCount(page.getResources(), ResourceKind.IMAGE));
            dataRow.createCell(2).setCellValue(getResourceCount(page.getResources(), ResourceKind.STYLESHEET));
            dataRow.createCell(3).setCellValue(getResourceCount(page.getResources(), ResourceKind.SCRIPT));
            dataRow.createCell(4).setCellValue(getLinkCount(page.getResources(), Locality.INTRAPAGE));
            dataRow.createCell(5).setCellValue(getLinkCount(page.getResources(), Locality.INTERNAL));
            dataRow.createCell(6).setCellValue(getLinkCount(page.getResources(), Locality.EXTERNAL));
        }

        // Auto-size the columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to the output file
        try (FileOutputStream fileOut = new FileOutputStream(baseFileName + ".xlsx")) {
            workbook.write(fileOut);
            System.out.printf("Excel Report Generated: %s%n", baseFileName + ".xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getResourceCount(List<Resource> resources, ResourceKind kind) {
        int count = 0;
        for (Resource resource : resources) {
            if (resource.getKind() == kind) {
                count++;
            }
        }
        return count;
    }

    private int getLinkCount(List<Resource> resources, Locality locality) {
        int count = 0;
        for (Resource resource : resources) {
            if (resource instanceof Anchor && ((Anchor) resource).getLocation() == locality) {
                count++;
            }
        }
        return count;
    }
}
=======
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
>>>>>>> b9e28fa88b0b03e389c43c55e466b7c37ad16a41
