package edu.odu.cs.cs350;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.*;


public class WebAnalysisTest {
    

    private WebsiteBuilder wb;

    @BeforeEach 
    void setUp(){
        wb = new WebsiteBuilder();

    }
    
    @Test
    void testWithPathInput() throws IOException {
        // Mock the user input
        String inputPath = "path/to/website/directory";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputPath.getBytes());
        System.setIn(inputStream);

    }

    @Test
    void testBuild(){
        Website site = wb.build();
        assertEquals(Website.class, site.getLocalDirectory());

    }

    @Test
    void testWithPath(){
        Path path = Path.of("path/to/website/directory");
        wb.withPath(path);
        assertEquals(path, wb.getPath());
    }

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


}
