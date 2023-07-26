package edu.odu.cs.cs350;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jsoup.Jsoup;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WebAnalysisTest {
    private ReportManager manager;
    private Website site;

     @Before
    public void setUp() {
        manager = new ReportManager();
        site = new Website(); // Assuming you have a testable SiteData object.
    }

    @Test
    public void testDetermineBaseFilename() {
        manager.setSourceData(site);
        String expectedBaseFilename = "expected_base_filename"; // Provide the expected base filename here.
        String actualBaseFilename = manager.determineBaseFilename();
        assertEquals(expectedBaseFilename, actualBaseFilename);
    }

    @Test
    public void testWriteAll() {
        manager.setSourceData(site);
        // Assuming the writeAll() method has some side effects (e.g., writes to a file or modifies data).
        // In this case, you may need to check the behavior and state changes rather than a direct return value.
        // For example, you could assert that a file was created or data was updated correctly.
        // For demonstration purposes, let's assume the writeAll() method returns a boolean indicating success.
        boolean writeSuccess = manager.writeAll();
        assertTrue(writeSuccess);
    }
    
}

    

    
    
