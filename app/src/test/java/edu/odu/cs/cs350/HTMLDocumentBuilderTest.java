package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLDocumentBuilderTest {
    @Test void HTMLDocumentBuilder() {
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
    }

    @Test void withContextFromFileTest() {
        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        Document Website = HTMLDoc.withContentFrom("SampleHTMLFile.html");
        Document testSite = Jsoup.parse("SampleHTMLFile.html");
        assertEquals(testSite,Website);
    }

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


}
