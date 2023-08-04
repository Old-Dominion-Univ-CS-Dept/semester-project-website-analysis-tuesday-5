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

class JSONReportWriterTest {
    @Test
    public void testWrite() {
        // Mock the necessary data
        Website website = mock(Website.class);
        List<HTMLDocument> pages = createMockHTMLDocuments();
        List<OtherFile> otherFiles = createMockOtherFiles();
        when(website.getPages()).thenReturn(pages);
        when(website.getOtherFiles()).thenReturn(otherFiles);

        JSONReportWriter reportWriter = new JSONReportWriter();
        reportWriter.setSourceData(website);
        reportWriter.setBaseName("website");

        // Call the write method
        reportWriter.write();

        // Perform assertions or verify the JSON output as needed
    }

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
    }
}

