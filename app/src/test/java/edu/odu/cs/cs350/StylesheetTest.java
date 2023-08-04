package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.nodes.Element;
import org.junit.Test;

import edu.odu.cs.cs350.enums.ResourceKind;

/**
*Stylesheet Test Class
*/

public class StylesheetTest {

    /**
    * Tests ability to create and properly display stylesheets
    */
    
    @Test public void StyleSheet() {
        StyleSheet StyleSheetTest = new StyleSheet();
        assertEquals(ResourceKind.STYLESHEET, StyleSheetTest.getKind());
        Element testElem = new Element("h1 {color: blue;}");
        StyleSheetTest.setContent(testElem);
        assertEquals("h1 {color: blue;}",StyleSheetTest.getContent().nodeName());
    }

    /**
    * Tests ability to extract stylesheets and stylesheet data
    @throws IOException
    */

    @Test public void extractStyleSheets() throws IOException {
        Path pathToTestFile = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir/site/testSite.html");
        FileReader testFile = new FileReader(pathToTestFile.toString());
        BufferedReader testHTML = new BufferedReader(testFile);

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(testHTML);
        HTMLDoc.extractStyleSheets();

        assertEquals(HTMLDoc.getStyleSheets().get(0).getContent().html(), "h1 {color: red;}");

    }
    
}
