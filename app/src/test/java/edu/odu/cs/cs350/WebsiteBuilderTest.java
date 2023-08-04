package edu.odu.cs.cs350;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is a test for the Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and obtains the website path and website url from each webpage. After obtaining all of that
 * information, it will build and return a website including its path and url.
 */

public class WebsiteBuilderTest {

    @Test

 /** 
* Tests Walk Directory function
@throws IOException
 */
    
    public void testWalkDirectory() throws IOException {
        // Create a temporary directory for testing
        Path tempDirectory = Files.createTempDirectory("testDirectory");

        // Create some temporary HTML files in the directory
        Path file1 = Files.createFile(tempDirectory.resolve("index.html"));
        Path file2 = Files.createFile(tempDirectory.resolve("about.html"));
        Path file3 = Files.createFile(tempDirectory.resolve("contact.html"));

        WebsiteBuilder websiteBuilder = new WebsiteBuilder();
        List<Path> htmlFiles = websiteBuilder.walkDirectory(tempDirectory);

        // Check if the returned list contains the correct number of HTML files
        assertEquals(3, htmlFiles.size());

        // Clean up - delete the temporary files and directory
        Files.delete(file1);
        Files.delete(file2);
        Files.delete(file3);
        Files.delete(tempDirectory);
    }

    @Test
  /** 
  * Tests Remove Non HTML Files function
  @throws IOException
 */
    public void testRemoveNonHTMLFiles() throws IOException {
        // Create a list of test files with various extensions
        List<Path> files = List.of(
                Paths.get("index.html"),
                Paths.get("about.html"),
                Paths.get("styles.css"),
                Paths.get("image.png"),
                Paths.get("script.js"),
                Paths.get("archive.zip"),
                Paths.get("video.mov"),
                Paths.get("document.pdf"),
                Paths.get("audio.mp3")
        );

        WebsiteBuilder websiteBuilder = new WebsiteBuilder();
        List<Path> htmlFiles = websiteBuilder.removeNonHTMLFiles(files);

        // Check if the returned list contains only HTML files
        assertEquals(2, htmlFiles.size());
        assertTrue(htmlFiles.contains(Paths.get("index.html")));
        assertTrue(htmlFiles.contains(Paths.get("about.html")));
    }
}
