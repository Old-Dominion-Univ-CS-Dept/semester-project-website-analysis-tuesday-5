package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.junit.Test;


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

    
    
}

