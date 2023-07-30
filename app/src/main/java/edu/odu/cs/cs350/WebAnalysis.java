package edu.odu.cs.cs350;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WebAnalysis {

    public static void main(String[] args) {
        String websitePath = args[0];

        List<String> urls = collectURLs(args);

        Website site = createWebsite(websitePath, urls);

        ReportManager manager = new ReportManager();
        manager.setSourceData(site);
        manager.determineBaseFilename();
        manager.writeAll();

        writeReportNames(manager);
    }

    // Method to collect URLs from command-line arguments
    public static List<String> collectURLs(String[] args) {
        return Arrays.stream(args)
                .skip(1)
                .collect(Collectors.toList());
    }

    // Method to create a Website object
    public static Website createWebsite(String websitePath, List<String> urls) {
        return new WebsiteBuilder()
                .withPath(websitePath)
                .withURLs(urls)
                .build();
    }

    // Method to write report names
    public static void writeReportNames(ReportManager manager) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            manager.writeReportNames(writer);
        } catch (IOException e) {
            System.err.println("Error occurred while writing reports: " + e.getMessage());
        }
    }
}
