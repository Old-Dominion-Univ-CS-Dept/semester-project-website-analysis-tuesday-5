package edu.odu.cs.cs350;

import edu.odu.cs.cs350.enums.Locality;
import edu.odu.cs.cs350.enums.ResourceKind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

/**
*Resource Test class
*/

public class ResourceTest {
    private Resource resource;

    /**
    *Sets up new resource for testing purposes
    */

    @BeforeEach
    public void setUp() {
        resource = new Resource();
    }

    /**
    * Tests getters and setter functions
    */

    @Test
    public void testGettersAndSetters() {
        Path testPath = Paths.get("test/resource/file.txt");
        String testUrl = "https://test.com/resource/file.txt";
        Locality testLocality = Locality.INTRAPAGE;
        ResourceKind testKind = ResourceKind.OTHER;
        long testSize = 1024;

        
        resource.setPath(testPath);
        resource.setUrl(testUrl);
        resource.setLocation(testLocality);
        resource.setKind(testKind);
        resource.setSizeOfFile(testSize);

      
        assertEquals(testPath, resource.getPath());
        assertEquals(testUrl, resource.getUrl());
        assertEquals(testLocality, resource.getLocation());
        assertEquals(testKind, resource.getKind());
        assertEquals(testSize, resource.getSizeOfFile());
    }
}
