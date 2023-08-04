package edu.odu.cs.cs350;

import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.OtherFile;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.enums.FileType;
import edu.odu.cs.cs350.JSONReportWriter;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

    private List<HTMLDocument> createMockHTMLDocuments() {
        List<HTMLDocument> pages = new ArrayList<>();

        HTMLDocument page1 = createMockHTMLDocument("index.html");
        HTMLDocument page2 = createMockHTMLDocument("about.html");

        pages.add(page1);
        pages.add(page2);

        return pages;
    }

    private HTMLDocument createMockHTMLDocument(String fileName) {
        HTMLDocument page = mock(HTMLDocument.class);
        when(page.getFileName()).thenReturn(String.valueOf(Path.of(fileName)));
        return page;
    }

    private List<OtherFile> createMockOtherFiles() {
        List<OtherFile> otherFiles = new ArrayList<>();

        OtherFile audioFile = createMockOtherFile("audio.mp3", FileType.AUDIO, 1024);
        OtherFile videoFile = createMockOtherFile("video.mp4", FileType.VIDEO, 2048);
        OtherFile archiveFile = createMockOtherFile("archive.zip", FileType.ARCHIVE, 4096);
        OtherFile uncategorizedFile = createMockOtherFile("file.txt", FileType.UNCATEGORIZED, 512);
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

        otherFiles.add(audioFile);
        otherFiles.add(videoFile);
        otherFiles.add(archiveFile);
        otherFiles.add(uncategorizedFile);

        return otherFiles;
    }

    private OtherFile createMockOtherFile(String fileName, FileType fileType, long fileSize) {
        OtherFile otherFile = mock(OtherFile.class);
        when(otherFile.getPath()).thenReturn(String.valueOf(Path.of(fileName)));
        when(otherFile.getFileType()).thenReturn(fileType);
        when(otherFile.getFileSize()).thenReturn(fileSize);
        return otherFile;
    
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

