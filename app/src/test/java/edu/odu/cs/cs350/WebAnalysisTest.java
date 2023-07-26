package edu.odu.cs.cs350;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jsoup.Jsoup;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WebAnalysisTest {
    @Test
    public void testMainMethod() throws IOException {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        // Prepare the test input
        String url = "https://example.com";
        String[] args = { url };
        
        // Call the main method
        WebAnalysis.main(args);
        
        // Restore System.out
        System.setOut(System.out);
        
        // Retrieve the captured output
        String output = outputStream.toString().trim();
        
        // Define the expected output
        String expectedOutput = "Expected output goes here...";
        
        // Perform assertions
        assertEquals(expectedOutput, output);
    }
}

    

    
    
