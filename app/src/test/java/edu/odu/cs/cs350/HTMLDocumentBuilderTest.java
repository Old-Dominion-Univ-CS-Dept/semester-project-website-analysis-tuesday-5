package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
*HTML Document Builder Test class
*/

public class HTMLDocumentBuilderTest {

    /**
    * Tests document builder's ability to create new document builder's
    */

    @Test public void HTMLDocumentBuilder() {
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
    }

    /**
    * Tests String Buffer Test's ability to properly read paths
    @throws IOException
    */

    @Test public void withContentFromStringBufferTest() throws IOException {
        Path pathToTestFile = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir/site/bufferTest.html");
        FileReader testFile = new FileReader(pathToTestFile.toString());
        BufferedReader comparison = new BufferedReader(testFile);
        

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(comparison);

        assertEquals(HTMLDoc.getHTMLContent().toString(), "<html>\n <head></head>\n <body>\n  test!\n </body>\n</html>");

    }

    /**
    * Tests File Test's ability to properly display the resultant path
    */

    @Test public void withContextFromFileTest() {
        System.out.println(System.getProperty("user.dir"));
        Path testingPath = Paths.get("src/main/java/edu/odu/cs/cs350/Anchor.java");
        assertEquals("C:\\Users\\hayes\\Documents\\CS350\\semester-project-website-analysis-tuesday-5\\app\\src\\main\\java\\edu\\odu\\cs\\cs350\\Anchor.java", testingPath.toAbsolutePath().toString());
    }

    /**
    * Tests base directory's ability to properly get and display the resultant path
    @throws IOException
    */

    @Test public void withBaseDirectoryTest() throws IOException {
        
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();

        Path path = Paths.get("C:/Users/hayes/Documents/CS350/semester-project-website-analysis-tuesday-5/app/src/test/java/edu/odu/cs/cs350/baseDir/");

        HTMLDoc.withBaseDirectory(path);

        assertEquals("C:\\Users\\hayes\\Documents\\CS350\\semester-project-website-analysis-tuesday-5\\app\\src\\test\\java\\edu\\odu\\cs\\cs350\\baseDir", HTMLDoc.getBaseDirectory().toString());
        

    }

    /**
    * Test's extract anchors function
    @throws IOException
    */

    @Test public void extractAnchorsTest() throws IOException {
        Path pathToTestFile = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir/site/testSite.html");
        FileReader testFile = new FileReader(pathToTestFile.toString());
        BufferedReader testHTML = new BufferedReader(testFile);

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(testHTML);
        HTMLDoc.extractAnchors();

        assertEquals(HTMLDoc.getAnchors().size(), 3);

    }

    /**
    * Test's extract images function
    @throws IOException
    */

    @Test public void extractImagesTest() throws IOException {
    Path pathToTestFile = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir/site/testSite.html");
    FileReader testFile = new FileReader(pathToTestFile.toString());
    BufferedReader testHTML = new BufferedReader(testFile);

    HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
    HTMLDoc.withContentFrom(testHTML);
    HTMLDoc.extractImages();

    assertEquals(HTMLDoc.getImages().size(), 1);

    }
   /* 
    @BeforeEach
    public void setUp() {
        File htmlFile = new File("src/main/test/java/edu/odu/cs/cs350/SampleHTMLFile.html");
    }

    @Test
    public void validateLinkTest() {
        HTMLLinkValidator.validateLinksInHTML(htmlFile);

        // Add assertions based on your expected behavior
        // For example, check if a specific link is visited or validated
        // You can also check if certain links are not visited or validated

        assertTrue(HTMLLinkValidator.visitedLinks.contains("http://example.com"));
        assertFalse(HTMLLinkValidator.visitedLinks.contains("http://invalid-link.com"));
    }

    @Test
    void testValidateLinksInHTML_withInvalidFile() {
        // Test the case where an invalid file is provided
        File invalidFile = new File("src/main/test/java/edu/odu/cs/cs350/SampleHTMLFile.html");

        // Assert that an IOException is thrown
        assertThrows(IOException.class, () -> HTMLLinkValidator.validateLinksInHTML(invalidFile));
    }

*/
}
