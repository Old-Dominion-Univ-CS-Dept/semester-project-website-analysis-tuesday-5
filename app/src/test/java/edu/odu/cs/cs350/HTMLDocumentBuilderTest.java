package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class HTMLDocumentBuilderTest {

    @Test public void HTMLDocumentBuilder() {
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
    }

    @Test public void withContentFromStringBufferTest() {
        String comparisonString = "<html><head><title>test</title></head></html>";
        StringBuffer testStringBuffer = new StringBuffer(comparisonString);

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(testStringBuffer);
        Document testDoc = Jsoup.parse(comparisonString.toString());

        assertEquals(HTMLDoc.getHTMLContent().toString(), testDoc.toString());

    }

    @Test public void withContextFromFileTest() {
        /* Save for the next increment

        File testHTML = new File("SampleHTMLFile.html");
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        Document Website = HTMLDoc.withContentFrom("SampleHTMLFile.html");
        Document testSite = Jsoup.parse(testHTML, "UTF-8", "http://www.cs.odu.edu/");
        assertEquals(testSite,Website);
        
        */
        System.out.println(System.getProperty("user.dir"));
        Path testingPath = Paths.get("src/main/java/edu/odu/cs/cs350/Anchor.java");
        assertEquals("C:\\Users\\hayes\\Documents\\CS350\\semester-project-website-analysis-tuesday-5\\app\\src\\main\\java\\edu\\odu\\cs\\cs350\\Anchor.java", testingPath.toAbsolutePath().toString());
    }

    @Test public void withBaseDirectoryTest() throws IOException {
        
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();

        Path path = Paths.get("C:/Users/hayes/Documents/CS350/semester-project-website-analysis-tuesday-5/app/src/test/java/edu/odu/cs/cs350/baseDir/");

        HTMLDoc.withBaseDirectory(path);

        assertEquals("C:\\Users\\hayes\\Documents\\CS350\\semester-project-website-analysis-tuesday-5\\app\\src\\test\\java\\edu\\odu\\cs\\cs350\\baseDir", HTMLDoc.getBaseDirectory().toString());
        

    }

    @Test public void extractAnchorsTest() {
        StringBuffer testHTML = new StringBuffer("<html><a href=\"https://www.google.com\" id=\"a1\">a1</a></html>");
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(testHTML);
        HTMLDoc.extractAnchors();

        assertEquals(HTMLDoc.getAnchors().size(), 1);

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
