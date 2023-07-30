package edu.odu.cs.cs350;

import edu.odu.cs.cs350.HTMLDocumentBuilder;
import edu.odu.cs.cs350.WebsiteBuilder;
import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.OtherFile;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.ReportManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class WebAnalysis {
    public static void main(String[] args) throws IOException {
        WebsiteBuilder wb = new WebsiteBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the website directory: ");
        Path path = Path.of(scanner.nextLine());


        wb.withPath(path);

        Website site = wb.build();
        site.setLocalDirectory(path);
        List<Path> htmlFiles = wb.walkDirectory(path);
        List<Path> prunedFiles = wb.removeNonHTMLFiles(htmlFiles);
        List<OtherFile> otherFiles = wb.extractOtherFiles(htmlFiles);
        site.setOtherFiles(otherFiles);

        for (Path htmlFile : prunedFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(htmlFile.toFile()))) {
                HTMLDocumentBuilder hb = new HTMLDocumentBuilder();
                hb.withContentFrom(reader);
                hb.setBaseDirectory(path);
                hb.setBaseURL(htmlFile);
                Document doc = Jsoup.parse(htmlFile.toFile(), "UTF-8");
                // Extract resources from HTML content
                hb.extractContent(doc);
                hb.setFilename(htmlFile.getFileName().toString());
                // Build the HTMLDocument
                // Add the HTMLDocument to the Website
                HTMLDocument page = hb.build();
                site.addPage(page);
            } catch (IOException e) {
                System.out.println("Error processing HTML file: " + htmlFile);
                e.printStackTrace();
            }
        }
//        wb.walkDirectoryOtherFile()
        ReportManager rm = new ReportManager();
        rm.setSourceData(site);
        rm.determineBaseFilename();

        rm.writeAll();

    }
}
