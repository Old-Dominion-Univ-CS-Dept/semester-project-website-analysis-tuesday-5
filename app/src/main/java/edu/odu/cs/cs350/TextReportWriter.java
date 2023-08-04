package edu.odu.cs.cs350;

import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.Resource;
import edu.odu.cs.cs350.Image;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

/** 
* TextReportWriter class
*/

public class TextReportWriter implements ReportWriter {
    private Website website;
    private String baseFileName;


    @Override
    public void setSourceData(Website website) {
        this.website = website;
    }
public class TextReportWriter {

    /** 
    * Write Text Report function
    @param fileName
    */
    
    public static void writeReport(String fileName){
        try {
            BufferedWriter Writer = new BufferedWriter(new FileWriter(fileName));

            Writer.write("Text report content.");

            Writer.close();
            System.out.println("Report written successfully.");
    }   catch (IOException e) {
            System.err.println("Error writing the report: " + e.getMessage());

    }
    }

    /**
    * Sets base name function
    @param baseFileName
    */
    
    @Override
    public void setBaseName(String baseFileName) {
        this.baseFileName = baseFileName;
    }
    
/**
* Write function
*/
    
    @Override
    public void write() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(baseFileName + "-summary.txt"))) {
            double totalSize = 0;

            for (HTMLDocument page : website.getPages()) {
                double pageSize = calculatePageSize(page);
                totalSize += pageSize;

                if (pageSize < 1024) {
                    // Write the page size and file path to the text file
                    writer.write(String.format("%.2f KB  %s", pageSize, page.getFileName()));
                    writer.newLine();
                } else {
                    // Write the page size and file path to the text file
                    writer.write(String.format("%.2f MB  %s", pageSize / 1024, page.getFileName()));
                    writer.newLine();
                }
            }

            if (totalSize < 1024) {
                // Write the total size to the last line of the file
                writer.write(String.format("Total Size: %.2fKB", totalSize));
            } else {
                writer.write(String.format("Total Size: %.2fMB", totalSize / 1024));
            }
            System.out.println("JSON report generated: " + baseFileName + "-summary.txt");

            // Write the total size to the last line of the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * Calculates Page Size function
    @param page
    */

    private double calculatePageSize(HTMLDocument page) {
        double pageSize = page.getFileSize();

        for (Resource resource : page.getResources()) {
            if (resource instanceof Image) {
                Image image = (Image) resource;
                for (OtherFile otherFile : website.getOtherFiles()) {
                    if (otherFile.getFileType().equals(FileType.IMAGE)) {
                        if (otherFile.getPath().endsWith(String.valueOf(image.getPath()))) {
                            pageSize += otherFile.getFileSize();
                        }
                    }
                }

            }
        }

        // Convert the size to MiB
        pageSize /= (1024);

        return pageSize;
    }
/**
* Sets Base Name function
@param baseFileName
*/
    
}
@Override
public void setBaseName(String baseFileName) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setBaseName'");
}

    /**
    * Write function
    */
    
@Override
public void write() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'write'");
}

}
    




