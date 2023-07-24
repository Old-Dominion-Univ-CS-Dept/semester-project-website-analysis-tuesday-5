package edu.odu.cs.cs350;

import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.Image;
import edu.odu.cs.cs350.Resource;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class TextReportWriter implements ReportWriter {
    private Website website;
    private String baseFileName;


    @Override
    public void setSourceData(Website website) {
        this.website = website;
    }

    @Override
    public void setBaseName(String baseFileName) {
        this.baseFileName = baseFileName;
    }

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

}

