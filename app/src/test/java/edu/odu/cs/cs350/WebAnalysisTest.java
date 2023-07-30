package edu.odu.cs.cs350;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebAnalysisTest {

//In this test, we verify the collectURLs() method by passing command-line arguments 
///with website paths and URLs. The method should correctly collect the URLs and return 
//them as a list. You can add more tests for other methods in a similar manner.
    @Test
    public void testCollectURLs() {
        String[] args = {"path/to/website", "https://example.com", "https://example.com/page1"};
        List<String> expectedUrls = Arrays.asList("https://example.com", "https://example.com/page1");

        List<String> actualUrls = WebAnalysis.collectURLs(args);

        assertEquals(expectedUrls, actualUrls);
    }
    @Test
    public void testCreateWebsite() {
        // Test data
        String websitePath = "/example/website";
        List<String> urls = Arrays.asList("https://www.example.com", "https://www.example.org");

        // Call the method
        Website website = createWebsite(websitePath, urls);

        // Check if the website object is created correctly
        assertEquals(websitePath, website.getPath());
        assertEquals(urls, website.getURLs());
    }
}
