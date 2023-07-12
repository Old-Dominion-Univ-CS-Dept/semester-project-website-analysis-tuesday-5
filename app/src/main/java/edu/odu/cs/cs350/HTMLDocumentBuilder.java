package edu.odu.cs.cs350;

import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * This is an HTML parser that takes URLs or files and extracts various tags (anchors,
 * images, stylesheets, JavaScript code) from each webpage. After extracting all of that
 * information, it will build and return an HTML Document.
 */
public class HTMLDocumentBuilder {

    /**
     * Parse HTML from a StringBuffer
     * 
     * @param StringBuffer HTML code
     * 
     * @return an HTML Document
     */
    public static Document withContentFrom(StringBuffer reader) {
        return Jsoup.parse(reader.toString());

    }
    
    /*
    public static Document withContentFrom(String file) {
        Hold all of this until next increment

        File inputFile = new File(file);
        return Jsoup.parse(inputFile, "UTF-8");


    }
    */

    public static void withBaseDirectory(String[] siteRoot) {

    }


    public static void withBaseURLs(Collection<?> URLs) {

    }

    /**
     * Extracts all anchors from a given HTML Document
     * 
     * @param an HTML Document
     * 
     * @return a Collection of all anchors found
     */
    public static Collection<?> extractAnchors(Document doc) {
        //Element content = doc.getElementById("content");
        Elements links = doc.getElementsByTag("a");
        return links;
    }

    public static void extractImages(Collection<?> Images) {

    }

    public static void extractScripts(Collection<?> Scripts) {

    }

    public static void extractStyleSheets(Collection<?> StyleSheets) {

    }

    public static void build(Document HTMLDocument) {

    }
    
}