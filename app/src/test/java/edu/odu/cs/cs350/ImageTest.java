package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.nodes.Element;
import org.junit.Test;

import edu.odu.cs.cs350.enums.ResourceKind;

/**
* Tests Image's ability to properly display and parse an image
*/

public class ImageTest {
    @Test public void Image() {
        Image imageTest = new Image();
        assertEquals(ResourceKind.IMAGE, imageTest.getKind());
        Element testElem = new Element("Oroboros.jpg");
        imageTest.setContent(testElem);
        assertEquals("Oroboros.jpg",imageTest.getContent().nodeName());
        
    }

    /**
    * Tests extract Images ability to extract image data
    */

    @Test public void extractImages() throws IOException {
        Path pathToTestFile = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir/site/testSite.html");
        FileReader testFile = new FileReader(pathToTestFile.toString());
        BufferedReader testHTML = new BufferedReader(testFile);

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(testHTML);
        HTMLDoc.extractImages();

        assertEquals(HTMLDoc.getImages().get(0).getContent().nodeName(), "https://avatars.githubusercontent.com/u/79117569?s=48&v=4");

    }
    
}
