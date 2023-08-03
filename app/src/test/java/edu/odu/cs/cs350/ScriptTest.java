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

public class ScriptTest {
    /**
    *Tests ability to obtain and create new scripts
    */
    
    @Test public void Script() {
        Script ScriptTest = new Script();
        assertEquals(ResourceKind.SCRIPT, ScriptTest.getKind());
        Element testElem = new Element("Console.log(\"Javascript code\")");
        ScriptTest.setContent(testElem);
        assertEquals("Console.log(\"Javascript code\")",ScriptTest.getContent().nodeName());
        
    }

    /**
    * Tests ability to extract scripts
    */

    @Test public void extractScripts() throws IOException {
        Path pathToTestFile = Paths.get("src/test/java/edu/odu/cs/cs350/baseDir/site/testSite.html");
        FileReader testFile = new FileReader(pathToTestFile.toString());
        BufferedReader testHTML = new BufferedReader(testFile);

        HTMLDocumentBuilder HTMLDoc = new HTMLDocumentBuilder();
        HTMLDoc.withContentFrom(testHTML);
        HTMLDoc.extractScripts();

        assertEquals(HTMLDoc.getScripts().get(0).getContent().html(), "console.log(\"acdefg\")");
    }
    
}
