
    package edu.odu.cs.cs350;

    import org.junit.Test;
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import static org.junit.Assert.*;
    
    public class TextReportWriterTest {
    
        @Test
        public void testWriteReport() throws IOException {
            
            String fileName = "test_report.txt";
            String expectedContent = "Text report content.";
    
           
            TextReportWriter.writeReport(fileName);
    
            
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String actualContent = reader.readLine();
                assertEquals(expectedContent, actualContent);
            }
        }
    }
       

