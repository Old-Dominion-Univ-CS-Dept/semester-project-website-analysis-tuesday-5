package edu.odu.cs.cs350;

import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HTMLDocumentBuilder {


    public static void withContentFrom(StringBuffer reader) {

    }

    public static Document withContentFrom(String file) {
        return Jsoup.parse(file, "UTF-8");
    }

    public static void withBaseDirectory(String[] siteRoot) {

    }


    public static void withBaseURLs(Collection<?> URLs) {

    }


    public static void extractAnchors(Collection<?> Anchors) {

    }

    public static void extractImages(Collection<?> Images) {

    }

    public static void extractScripts(Collection<?> Scripts) {

    }

    public static void extractStyleSheets(Collection<?> StyleSheets) {

    }

    public static void build(HTMLDocument) {

    }
    
}
