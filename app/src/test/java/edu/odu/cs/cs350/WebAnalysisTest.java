package edu.odu.cs.cs350;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
* Web Analysis Test class
*/
public class WebAnalysisTest {
    

    private WebsiteBuilder wb;

    /**
    *Sets up testing parameters
    */

    @BeforeEach 
    void setUp() throws IOException {
        wb = new WebsiteBuilder();
    }

    /**
    * Tests Input Stream given user input
    @throws IOException
    */
    
    @Test
    void testWithPathInput() throws IOException {
        // Mock the user input
        String inputPath = "path/to/website/directory";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputPath.getBytes());
        System.setIn(inputStream);

    }

    /**
    * Tests build function
    */

    @Test
    void testBuild() throws IOException {
        Website site = wb.build();
        assertEquals(Website.class, site.getLocalDirectory());

    }

    /**
    * Tests path output is equivalent to path input
    */

    @Test
    void testWithPath(){
        Path path = Path.of("path/to/website/directory");
        wb.withPath(path);
        assertEquals(path, wb.getPath());
    }

    /**
    * Tests directory walker function
    @Throws IOException
    */

    @Test
    void testWalkDirectory() throws IOException {
        Path path = Path.of("path/to/website/directory");
        wb.withPath(path);
        // Mock the DirectoryStream<Path> returned by Files.newDirectoryStream
        DirectoryStream<Path> directoryStream = mock(DirectoryStream.class);
        when(Files.newDirectoryStream(path)).thenReturn(directoryStream);
        when(directoryStream.iterator()).thenReturn(Arrays.asList(Path.of("file1.html"), Path.of("file2.txt")).iterator());

        List<Path> result = wb.walkDirectory(path);

        assertEquals(2, result.size());
        assertEquals(Path.of("file1.html"), result.get(0));
        assertEquals(Path.of("file2.txt"), result.get(1));
    }

    /**
    * Tests Remove Non HTML Files function
    */

    @Test
    void testRemoveNonHTMLFiles() {
        List<Path> files = Arrays.asList(
                Path.of("file1.html"),
                Path.of("file2.txt"),
                Path.of("file3.html")
        );

        List<Path> result = wb.removeNonHTMLFiles(files);

        assertEquals(2, result.size());
        assertEquals(Path.of("file1.html"), result.get(0));
        assertEquals(Path.of("file3.html"), result.get(1));
    }

    @Test
    void HTMLDocumentBuilder() throws IOException {
        Path path = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir");
        wb.withPath(path);
        Website site = wb.build();

    }


    @Test
    public void testDetermineBaseFilename() {
        Website site = new Website();
        ReportManager rm = new ReportManager();
        rm.setSourceData(site);
        rm.determineBaseFilename();

        String expectedBaseFilename = "path/to/website/directory";
        assertEquals(expectedBaseFilename, rm.getBaseFilename());
    }


}
