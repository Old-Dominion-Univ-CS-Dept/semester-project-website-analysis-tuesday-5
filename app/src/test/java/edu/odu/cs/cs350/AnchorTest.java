package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import org.jsoup.nodes.Element;
import org.junit.Test;


public class AnchorTest {

    @Test public void Anchor() {
        Anchor blankAnchor = new Anchor();
        
        assertEquals(blankAnchor.getContent(), null);
        assertEquals(blankAnchor.getFoundOn(), null);
        //assertEquals(blankAnchor.getLocality(), null);

        HTMLDocument testDoc = new HTMLDocument();
        Element testContent = new Element("test data");

        Anchor withData = new Anchor(testDoc, testContent);

        assertEquals(withData.getContent().nodeName().toString(), "test data");
        
    }
    
}