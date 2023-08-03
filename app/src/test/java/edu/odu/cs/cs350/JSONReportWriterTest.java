package edu.odu.cs.cs350;

import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.OtherFile;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.Image;
import edu.odu.cs.cs350.Resource;
import edu.odu.cs.cs350.Script;
import edu.odu.cs.cs350.StyleSheet;
import edu.odu.cs.cs350.enums.FileType;
import edu.odu.cs.cs350.JSONReportWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
*JSON Report integration test class
*/

public class JSONReportIntegrationTest {
    private Website website;
    private JSONReportWriter jsonReportWriter;

    /**
    *Sets up JSON Report Writer tests
    */

    @BeforeEach
    public void setUp() {
        // Set up the test environment
        website = new Website();

        // Create some pages
        HTMLDocument page1 = new HTMLDocument();
        page1.setFileName("page1.html");
        page1.setFileSize(1024);
        page1.setResources(new ArrayList<>());

        HTMLDocument page2 = new HTMLDocument();
        page2.setFileName("page2.html");
        page2.setFileSize(2048);
        page2.setResources(new ArrayList<>());

        // Add resources to the pages
        Resource imageResource1 = new Image();
        imageResource1.setPath(Path.of("/images/image1.png"));
        page1.getResources().add(imageResource1);

        Resource imageResource2 = new Image();
        imageResource2.setPath(Path.of("/images/image2.png"));
        page1.getResources().add(imageResource2);

        Resource scriptResource1 = new Script();
        scriptResource1.setPath(Path.of("/scripts/script1.js"));
        page2.getResources().add(scriptResource1);

        Resource styleResource1 = new StyleSheet();
        styleResource1.setPath(Path.of("/styles/style1.css"));
        page2.getResources().add(styleResource1);

        // Add the pages to the website
        List<HTMLDocument> pages = new ArrayList<>();
        pages.add(page1);
        pages.add(page2);
        website.setPages(pages);

        // Create some OtherFiles
        List<OtherFile> otherFiles = new ArrayList<>();
        otherFiles.add(new OtherFile("audio1.mp3", "audio", 512, "/audio/audio1.mp3", FileType.AUDIO));
        otherFiles.add(new OtherFile("video1.mp4", "video", 1024, "/video/video1.mp4", FileType.VIDEO));
        otherFiles.add(new OtherFile("archive1.zip", "archive", 2048, "/archives/archive1.zip", FileType.ARCHIVE));
        otherFiles.add(new OtherFile("uncategorized1.txt", "uncategorized", 256, "/uncategorized/uncategorized1.txt", FileType.UNCATEGORIZED));
        website.setOtherFiles(otherFiles);

        jsonReportWriter = new JSONReportWriter();
        jsonReportWriter.setSourceData(website);
        jsonReportWriter.setBaseName("test-report");
    }

    /**
    * Tests JSON report writer's ability to properly integrate the data necessary to generate a JSON report
    @throws IOException
    */

    @Test
    public void testJSONReportWriterIntegration() throws IOException {
        // Call the write method to generate the JSON report
        jsonReportWriter.write();

        // Read the generated JSON report from the file
        String jsonReportFilePath = "test-report-summary.json";
        String jsonReportContent = readJSONReportFile(jsonReportFilePath);

        // Assert that the JSON report contains expected content
        assertThat(jsonReportContent, containsString("\"Pages\""));
        assertThat(jsonReportContent, containsString("\"Image Files\""));
        assertThat(jsonReportContent, containsString("\"Archive Files\""));
        assertThat(jsonReportContent, containsString("\"Video Files\""));
        assertThat(jsonReportContent, containsString("\"Audio Files\""));
        assertThat(jsonReportContent, containsString("\"Uncategorized Files\""));

    }
    
/**
* Helper method to read the content of the JSON report file
@return contentBuilder.toString()
*/
    
    private String readJSONReportFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }
}
