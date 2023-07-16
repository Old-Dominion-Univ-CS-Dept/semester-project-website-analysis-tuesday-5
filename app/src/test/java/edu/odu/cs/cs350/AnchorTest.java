package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;


public class AnchorTest {

    @Test void Anchor() {
        Anchor blankAnchor = new Anchor();
        
        assertEquals(blankAnchor.getContent(), null);
        assertEquals(blankAnchor.getFoundOn(), null);
        assertEquals(blankAnchor.getLocality(), null);

        HTMLDocument testDoc = new HTMLDocument();
        Element testContent = new Element("test data");

        Anchor withData = new Anchor(testDoc, testContent);

        assertEquals(withData.getContent().toString(), "<test data></test data>");
        assertEquals(withData.getFoundOn(), testDoc);
        assertEquals(withData.getLocality(), null);
        
    }
    
}