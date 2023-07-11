package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

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

    @Test void extractAnchorsTest() {
        StringBuffer testHTML = new StringBuffer("<html><a id=\"a1\">a1</a><a id=\"a2\">a2</a></html>");
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        Document functionExtraction = HTMLDoc.withContentFrom(testHTML);
        Collection<?> functionLinks = HTMLDoc.extractAnchors(functionExtraction);

        assertEquals(functionLinks.toString(), "<a id=\"a1\">a1</a>\n<a id=\"a2\">a2</a>");

    }
   /* 
    @BeforeEach
    public void setUp() {
        LinkValidator linkValidator = new LinkValidator();
        HashSet visitedLinks = new HashSet<>();
    }

    @Test
    public void testValidateLink() {
        String link1 = "https://example.com/link1";
        String link2 = "https://example.com/link2";
        String link3 = "https://example.com/link3";

        // Validate the first link
        boolean isValid1 = linkValidator.validateLink(link1, visitedLinks);
        Assertions.assertTrue(isValid1);
        Assertions.assertTrue(visitedLinks.contains(link1));

        // Validate the second link
        boolean isValid2 = linkValidator.validateLink(link2, visitedLinks);
        Assertions.assertTrue(isValid2);
        Assertions.assertTrue(visitedLinks.contains(link2));

        // Validate the third link (which has been visited before)
        visitedLinks.add(link3);
        boolean isValid3 = linkValidator.validateLink(link3, visitedLinks);
        Assertions.assertFalse(isValid3);
    }

*/
}
