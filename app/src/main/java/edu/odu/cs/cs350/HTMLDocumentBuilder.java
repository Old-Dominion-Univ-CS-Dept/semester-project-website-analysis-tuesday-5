package edu.odu.cs.cs350;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

import java.util.HashSet;
import java.util.Set;
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

    public static Collection<?> extractImages(Image image) {

        Elements images = image.getElementsByTag("a");
        return images;

    }

    public static Collection<?> extractScripts(Script script) {

        Elements scripts = script.getElementsByTag("a");
        return scripts;

    }

    public static Collection<?> extractStyleSheets(Stylesheet StyleSheet) {

        Elements stylesheets = StyleSheet.getElementsByTag("a");
        return stylesheets;

    }

    public static void build(Document HTMLDocument) {

    }

    public static void validateLink(File htmlFile){
        try {
            Document document = Jsoup.parse(htmlFile, "UTF-8");

            //Select all <a> tags with href attribute
            document.select("a[href]");
            for (Element link : links){
                String url = link.attr("href");

                if (visitedLinks.contains(url)){
                    System.out.println(url + " has already been visited.");
                } else{
                    visitedLinks.add(url);
                    if (validateLink(url)) {
                        System.out.println(url + " is a valid link.");
                    } else {
                         System.out.println(url + " is not a valid link.");
                    }
                }

            }

        } 
        catch (IOException e){
            System.out.println("Error reading HTML file: " + e.getMessage());
        }  
        }
         public static boolean validateLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
         } catch (Exception e){
            return false;
         }

    }

    
}
