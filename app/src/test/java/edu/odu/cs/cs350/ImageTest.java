package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import org.jsoup.nodes.Element;
import org.junit.Test;

import edu.odu.cs.cs350.enums.ResourceKind;

public class ImageTest {
    @Test public void Image() {
        Image imageTest = new Image();
        assertEquals(ResourceKind.IMAGE, imageTest.getKind());
        Element testElem = new Element("Oroboros.jpg");
        imageTest.setContent(testElem);
        assertEquals("Oroboros.jpg",imageTest.getContent().nodeName());
        
    }
    
}