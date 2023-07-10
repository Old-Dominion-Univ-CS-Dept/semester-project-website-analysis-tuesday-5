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

        assertEquals(functionDoc, testDoc);

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

        assertEquals(functionLinks, "a1");

    }

}
