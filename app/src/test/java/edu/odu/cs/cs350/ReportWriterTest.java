package edu.odu.cs.cs350;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportWriterTest {

    /**
    * Tests ability to create an expected json file name
    */

    @Test
    public void testJsonExtension() {
        String extension = "json";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String expectedFileName = now.format(formatter) + "-summary." + extension;

        String fileName = ReportWriter.nameFile(extension);

        assertEquals(expectedFileName, fileName);
    }

    /**
    * Tests ability to create a proper text extension and date time format
    */

    @Test
    public void testTxtExtension() {
        String extension = "txt";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String expectedFileName = now.format(formatter) + "-summary." + extension;

        String fileName = ReportWriter.nameFile(extension);

        assertEquals(expectedFileName, fileName);
    }

    /**
    * Tests ability to create a proper xlsx extension and date time format
    */

    @Test
    public void testXlsxExtension() {
        String extension = "xlsx";
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String expectedFileName = now.format(formatter) + "-summary." + extension;

        String fileName = ReportWriter.nameFile(extension);

        assertEquals(expectedFileName, fileName);
    }
}
