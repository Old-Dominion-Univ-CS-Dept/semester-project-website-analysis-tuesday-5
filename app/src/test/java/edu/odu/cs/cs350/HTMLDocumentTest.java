package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.junit.Test;

import edu.odu.cs.cs350.enums.Locality;


public class HTMLDocumentTest {

    @Test 
    public void testHTMLDocument() {
        Element testElement = new Element("Thursdays are just baby Fridays");
        String sampleHTML = "<html></html>";
        HTMLDocument HTMLDoc = new HTMLDocument();

        Anchor testAnchor = new Anchor(HTMLDoc, testElement);

        ArrayList<Anchor> testArrayList = new ArrayList<Anchor>();


        testArrayList.add(testAnchor);

        HTMLDocument constructorHTMLDocument = new HTMLDocument(testArrayList);

        assertEquals(testElement,constructorHTMLDocument.getAnchors().get(0).getContent());

    }

    @Test
    public void testAnchorCategorization() throws IOException {
        HTMLDocumentBuilder HTMLDocBuilder = new HTMLDocumentBuilder();
        Path pathToTestSite = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir");
        HTMLDocBuilder.withBaseDirectory(pathToTestSite);
        HTMLDocBuilder.withContentFrom("src/test/java/edu/odu/cs/cs350/baseDir/site/testSite.html");
        HTMLDocBuilder.extractAnchors();
        //HTMLDocBuilder.withPathToDoc(pathToTestSite);
        HTMLDocument HTMLDoc = HTMLDocBuilder.build();

        HTMLDoc.categorizeAnchors();
        assertEquals(3, HTMLDoc.getAnchors().size());
        assertEquals(Locality.INTRAPAGE, HTMLDoc.getAnchors().get(0).getLocation());
        assertEquals(Locality.EXTERNAL, HTMLDoc.getAnchors().get(1).getLocation());
        assertEquals(Locality.INTERNAL, HTMLDoc.getAnchors().get(2).getLocation());
    }

    
    
}

