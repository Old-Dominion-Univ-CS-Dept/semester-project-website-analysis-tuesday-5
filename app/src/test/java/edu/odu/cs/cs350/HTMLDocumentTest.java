package edu.odu.cs.cs350;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HTMLDocumentTest {

    @Test void testHTMLDocument() {
        Element testElement = new Element("Thursdays are just baby Fridays");
        ArrayList<Element> testArrayList = new ArrayList<Element>();
        testArrayList.add(testElement);

        HTMLDocument constructorHTMLDocument = new HTMLDocument(testArrayList);

        assertEquals(Integer.valueOf(constructorHTMLDocument.getAnchors().size()), 1);

    }

    
    
}

