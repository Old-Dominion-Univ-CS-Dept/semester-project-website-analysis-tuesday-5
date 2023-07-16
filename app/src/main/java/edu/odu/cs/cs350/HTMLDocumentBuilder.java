package edu.odu.cs.cs350;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This is an HTML parser that takes URLs or files and extracts various tags (anchors,
 * images, stylesheets, JavaScript code) from each webpage. After extracting all of that
 * information, it will build and return an HTML Document.
 */
public class HTMLDocumentBuilder {
    ArrayList<Anchor> extractedAnchors = new ArrayList<Anchor>();

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

    public static void withBaseDirectory(String siteRoot) {

    }


    public static void withBaseURLs(Collection<?> URLs) {

    }

    /**
     * Extracts all anchors from a given HTML Document
     * 
     * @param an HTML Document
     * 
     * @return an ArrayList of all anchors found
     */
    public static ArrayList<Anchor> extractAnchors(Document doc) {
        ArrayList<Anchor> anchors = new ArrayList<Anchor>();
        //Element content = doc.getElementById("content");
        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
            Anchor a = new Anchor(link);
            anchors.add(a);
        }

        return anchors;
    }


    /**
     * Builds a completed HTMLDocument object
     * 
     * @param A StringBuffer object
     * 
     * @return an HTMLDocument object
     */
    public static HTMLDocument build(StringBuffer StrBuffer) {
        Document doc = withContentFrom(StrBuffer);
        HTMLDocument HTMLDoc = new HTMLDocument();
        ArrayList<Anchor> docAnchors = extractAnchors(doc);
        HTMLDoc.setAnchors(HTMLDoc, docAnchors);

        return HTMLDoc;
    }


    
}
