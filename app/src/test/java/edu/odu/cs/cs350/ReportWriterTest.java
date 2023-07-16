package edu.odu.cs.cs350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportWriterTest {
    @Test
    public void testJsonExtension() {
        String extension = "json";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String expectedFileName = now.format(formatter) + "-summary." + extension;

        String fileName = ReportWriter.nameFile(extension);

        Assertions.assertEquals(expectedFileName, fileName);
    }

    @Test
    public void testTxtExtension() {
        String extension = "txt";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String expectedFileName = now.format(formatter) + "-summary." + extension;

        String fileName = ReportWriter.nameFile(extension);

        Assertions.assertEquals(expectedFileName, fileName);
    }

    @Test
    public void testXlsxExtension() {
        String extension = "xlsx";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String expectedFileName = now.format(formatter) + "-summary." + extension;

        String fileName = ReportWriter.nameFile(extension);

        Assertions.assertEquals(expectedFileName, fileName);
    }
}
