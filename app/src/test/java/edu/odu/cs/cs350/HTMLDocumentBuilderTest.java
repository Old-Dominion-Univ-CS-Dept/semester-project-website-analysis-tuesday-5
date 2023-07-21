package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Collection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Class;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HTMLDocumentBuilderTest {

    @Test void HTMLDocumentBuilder() {
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
    }

    @Test void withContentFromStringBufferTest() {
        String comparisonString = "<html><head><title>test</title></head></html>";
        StringBuffer testStringBuffer = new StringBuffer(comparisonString);

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        Document functionDoc = HTMLDoc.withContentFrom(testStringBuffer);
        Document testDoc = Jsoup.parse(comparisonString.toString());

        assertEquals(functionDoc.toString(), testDoc.toString());

    }

    @Test void withContextFromFileTest() {
        /* Save for the next increment

        File testHTML = new File("SampleHTMLFile.html");
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        Document Website = HTMLDoc.withContentFrom("SampleHTMLFile.html");
        Document testSite = Jsoup.parse(testHTML, "UTF-8", "http://www.cs.odu.edu/");
        assertEquals(testSite,Website);
        
        */
    }

    @Test void withBaseDirectoryTest() {
        /*
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();

        HTMLDoc.withBaseDirectory("C:/Users/hayes/Documents/CS350/semester-project-website-analysis-tuesday-5/app/src/test/java/edu/odu/cs/cs350/baseDir/");
        assertTrue(HTMLDoc.getBaseDir() != null);
        */
        

    }

    @Test void extractAnchorsTest() {
        StringBuffer testHTML = new StringBuffer("<html><a id=\"a1\">a1</a></html>");
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        Document functionExtraction = HTMLDoc.withContentFrom(testHTML);
        ArrayList<Anchor> functionLinks = HTMLDoc.extractAnchors(functionExtraction);

        assertEquals(functionLinks.get(0).getContent().toString(), "<a id=\"a1\">a1</a>");

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
