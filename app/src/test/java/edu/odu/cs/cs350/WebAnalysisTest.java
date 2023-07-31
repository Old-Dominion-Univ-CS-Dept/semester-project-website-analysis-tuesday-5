package edu.odu.cs.cs350;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.*;


public class WebAnalysisTest {
	
	@Test
    void testWithPathInput() throws IOException {
        // Mock the user input
        String inputPath = "path/to/website/directory";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputPath.getBytes());
        System.setIn(inputStream);

    }
}