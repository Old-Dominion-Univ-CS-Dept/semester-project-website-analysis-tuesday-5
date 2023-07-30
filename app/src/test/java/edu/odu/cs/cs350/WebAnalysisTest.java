package edu.odu.cs.cs350;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Paths;


public class WebAnalysisTest {
     private WebAnalysis webAnalysis;

     @BeforeEach
    void setUp() {
        webAnalysis = new WebAnalysis();
    }

    @Test
    void testBuildWebsite() throws IOException {
        //  you have a test website directory with HTML files for testing
        String testDirectory = "path/to/test/website";
        Website website = webAnalysis.buildWebsite(Paths.get(testDirectory));
        assertNotNull(website);
        // Add more assertions to validate the structure of the built website
    }

    @Test
    void testSetSourceData() {
        // Assuming you have a Website instance for testing
        Website testWebsite = new Website();
        webAnalysis.setSourceData(testWebsite);
        // Add assertions if needed
    }

    @Test
    void testDetermineBaseFilename() {
        // Assuming you have set up the necessary data for the report manager
        webAnalysis.determineBaseFilename();
        // Add assertions if needed
    }

    @Test
    void testWriteAll() {
        // Assuming you have set up the necessary data for the report manager
        webAnalysis.writeAll();
        // Add assertions if needed
    }




}
