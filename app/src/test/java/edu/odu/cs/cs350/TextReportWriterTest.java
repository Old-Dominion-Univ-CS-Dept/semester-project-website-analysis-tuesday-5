package edu.odu.cs.cs350;

import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.OtherFile;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.enums.FileType;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TextReportWriterTest {
    /**
    * Tests report writer's ability to write and create data
    */
    
    @Test
    public void testWrite() {
        // Mock the necessary data
        Website website = mock(Website.class);
        List<HTMLDocument> pages = createMockHTMLDocuments();
        List<OtherFile> otherFiles = createMockOtherFiles();
        when(website.getPages()).thenReturn(pages);
        when(website.getOtherFiles()).thenReturn(otherFiles);

        TextReportWriter reportWriter = new TextReportWriter();
        reportWriter.setSourceData(website);
        reportWriter.setBaseName("website");

        // Call the write method
        reportWriter.write();

        // Perform assertions or verify the generated text output as needed
    }

    private List<HTMLDocument> createMockHTMLDocuments() {
        List<HTMLDocument> pages = new ArrayList<>();

        HTMLDocument page1 = createMockHTMLDocument("index.html", 1024);
        HTMLDocument page2 = createMockHTMLDocument("about.html", 2048);

        pages.add(page1);
        pages.add(page2);

        return pages;
    }

    private HTMLDocument createMockHTMLDocument(String fileName, long fileSize) {
        HTMLDocument page = mock(HTMLDocument.class);
        when(page.getFileName()).thenReturn(String.valueOf(Path.of(fileName)));
        when(page.getFileSize()).thenReturn(fileSize);
        return page;
    }

    private List<OtherFile> createMockOtherFiles() {
        List<OtherFile> otherFiles = new ArrayList<>();

        OtherFile imageFile = createMockOtherFile("image.png", FileType.IMAGE, 512);
        OtherFile otherFile1 = createMockOtherFile("file1.txt", FileType.UNCATEGORIZED, 256);
        OtherFile otherFile2 = createMockOtherFile("file2.txt", FileType.UNCATEGORIZED, 128);

        otherFiles.add(imageFile);
        otherFiles.add(otherFile1);
        otherFiles.add(otherFile2);

        return otherFiles;
    }

    private OtherFile createMockOtherFile(String fileName, FileType fileType, long fileSize) {
        OtherFile otherFile = mock(OtherFile.class);
        when(otherFile.getPath()).thenReturn(String.valueOf(Path.of(fileName)));
        when(otherFile.getFileType()).thenReturn(fileType);
        when(otherFile.getFileSize()).thenReturn(fileSize);
        return otherFile;
    }
}
