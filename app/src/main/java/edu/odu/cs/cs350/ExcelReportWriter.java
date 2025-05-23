package edu.odu.cs.cs350;

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

public class ExcelReportWriter implements ReportWriter {
    private Website website;
    private String baseFileName;
    @Override
    public void setSourceData(Website website) {
        this.website = website;
    }

    /**
    * Sets base file name function
    @param baseFileName
    */

    @Override
    public void setBaseName(String baseFileName) {
        this.baseFileName = baseFileName+"-summary";

    }

    /**
    * Gets website and website parameters (I.E Path and URL) function
    @return website
    */

    @Override
    public Website getWebsite() {
        return website;
    }

    /**
    * Gets Base file name function
    @return baseFileName
    */

    @Override
    public String getBaseFileName() {
        return baseFileName;
    }

    /**
    * write function
    */

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

    /**
    * Get resource count function
    @param resources
    @param kind
    @return count
    */

    private int getResourceCount(List<Resource> resources, ResourceKind kind) {
        int count = 0;
        for (Resource resource : resources) {
            if (resource.getKind() == kind) {
                count++;
            }
        }
        return count;
    }

    /**
    @param resources
    @param locality
    @return count
    */

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
