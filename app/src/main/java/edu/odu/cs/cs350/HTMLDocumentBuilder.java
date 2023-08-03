package edu.odu.cs.cs350;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This is an HTML parser that takes URLs or files and extracts various tags (anchors,
 * images, StyleSheets, JavaScript code) from each webpage. After extracting all of that
 * information, it will build and return an HTML Document.
 */
public class HTMLDocumentBuilder {

    Path baseDir;
    private ArrayList<URL> baseUrls;

    private ArrayList<Anchor> anchors;
    private ArrayList<Image> images;
    private ArrayList<Script> scripts;
    private ArrayList<StyleSheet> StyleSheets;

    private Document HTMLDocumentContent;

    private Path pathToSourceDoc;


    ArrayList<Anchor> extractedAnchors = new ArrayList<Anchor>();

    /**
     * Default constructor for HTMLDocumentBuilder
     * 
     * @param none
     * 
     * @return none
     */
    public HTMLDocumentBuilder() {
        this.anchors = new ArrayList<>();
        this.images = new ArrayList<>();
        this.scripts = new ArrayList<>();
        this.StyleSheets = new ArrayList<>();
    }

    /**
     * Parse HTML from a StringBuffer
     * 
     * @param StringBuffer HTML code
     * 
     * @return an HTML Document
     */
    public void withContentFrom(BufferedReader reader) throws IOException {
        String htmlCodeAsString = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        this.HTMLDocumentContent = Jsoup.parse(htmlCodeAsString);

    }
    
    /**
     * Parse HTML content from a filepath
     * 
     * @param file (string)
     * 
     * @return none
     * 
     * @throws IOException
     */
    public void withContentFrom(String file) 
        throws IOException 
    {
        File inputFile = new File(file);
        this.HTMLDocumentContent = Jsoup.parse(inputFile, "UTF-8");
        this.pathToSourceDoc = Paths.get(file).normalize();
        //this.webPages.add(filePath);
    }

    /**
     * Accessor for the HTML content of the HTMLDocument object
     * 
     * @param none
     * 
     * @return A document object containing the HTML content
     */
    public Document getHTMLContent() {
        return this.HTMLDocumentContent;
    }

    /**
    * Set path to the HTMLDocument
    *
    * @param htmlPath
    *
    * @return none
    */

    public void withPathToDoc(Path htmlPath) {
        this.pathToSourceDoc = htmlPath;
    }

    /**
    * Set base directory that the HTMLDocument is housed in
    * @param siteRoot
    *
    * @throws IOException
    *
    * @return none
    */
    

    public void withBaseDirectory(Path siteRoot) throws IOException {
        this.baseDir = siteRoot;
    }

    /**
     * Accessor for base directory
     * 
     * @param none
     * 
     * @return Path object for the base directory
     */
    public Path getBaseDirectory() {
        return this.baseDir;
    }

    /**
     * Set base URLS for the HTMLDocument object
     * 
     * @param an ArrayList of URLs
     * 
     * @return none
     */

    public void withBaseURLs(ArrayList<URL> URLs) {
        this.baseUrls = URLs;
    }

    /**
     * Extracts all anchors from a given HTML Document
     * 
     * @param an HTML Document
     * 
     * @return an ArrayList of all anchors found
     */
    public void extractAnchors() {
        this.anchors = new ArrayList<>();
        //Element content = doc.getElementById("content");
        Elements links = HTMLDocumentContent.select("a[href]");
        //links.attr("href");
        for (Element link : links) {
            Element linkHref = new Element(link.attr("href"));
            Anchor a = new Anchor(linkHref);
            this.anchors.add(a);
        }
    }

    /**
     * Extracts all anchors from a given HTML Document
     * 
     * @param an HTML Document
     * 
     * @return an ArrayList of all anchors found
     */
    public void extractImages() throws IOException {
        this.images = new ArrayList<>();
        Elements images = HTMLDocumentContent.select("img[src]");
        for (Element image : images) {
            Element picture = new Element(image.attr("src"));
            Image a = new Image(picture);
            this.images.add(a);
        }
    }

    /**
     * Accessor for ArrayList of Images in the HTMLDocument
     * 
     * @param none
     * 
     * @return ArrayList of Images
     */
    public ArrayList<Image> getImages() {
        return this.images;
    }

    /**
     * Extracts all anchors from a given HTML Document
     * 
     * @param an HTML Document
     * 
     * @return an ArrayList of all anchors found
     */
    public void extractScripts() {
        this.scripts = new ArrayList<>();
        Elements scripts = HTMLDocumentContent.select("script");
        for (Element script : scripts) {
            Script s = new Script(script);
            this.scripts.add(s);
        }
    }

    /**
     * Accessor for scripts in the HTMLDocument
     * 
     * @param none
     * 
     * @return ArrayList of Scripts
     */
    public ArrayList<Script> getScripts() {
        return this.scripts;
    }

    /**
     * Extracts all inline Style tags and information for the HTMLDocument
     * 
     * @param none
     * 
     * @return none
     */
    public void extractStyleSheets() {
        this.StyleSheets = new ArrayList<>();
        Elements StyleSheets = HTMLDocumentContent.select("style");
        for (Element StyleSheet : StyleSheets) {
            StyleSheet s = new StyleSheet(StyleSheet);
            this.StyleSheets.add(s);
        }
    }   

    /**
     * Accessor for ArrayList of StyleSheets
     * 
     * @param none
     * 
     * @return ArrayList of StyleSheets in the HTMLDocument
     */
    public ArrayList<StyleSheet> getStyleSheets() {
        return this.StyleSheets;
    }

    /**
     * Accessor for ArrayList of Anchors
     * 
     * @param none
     * 
     * @return anchors ArrayList
     */
    public ArrayList<Anchor> getAnchors() {
        return anchors;
    }

    /**
     * Simplified extraction function. Extracts all content in the HTMLDocument
     * 
     * @param none
     * 
     * @return none
     * 
     * @throws IOException
     */
    public void extractContent() throws IOException {
        this.extractAnchors();
        this.extractImages();
        this.extractScripts();
        this.extractStyleSheets();
    }


    /**
     * Builds a completed HTMLDocument object
     * 
     * @param None
     * 
     * @return an HTMLDocument object
     * 
     * @throws IOException
     */
    public HTMLDocument build() throws IOException {
        HTMLDocument HTMLDoc = new HTMLDocument();
        HTMLDoc.setHTMLContent(HTMLDocumentContent);
        this.extractContent();
        HTMLDoc.setAnchors(HTMLDoc, anchors);
        HTMLDoc.setImages(HTMLDoc, images);
        HTMLDoc.setScripts(HTMLDoc, scripts);
        HTMLDoc.setStyleSheets(HTMLDoc, StyleSheets);
        HTMLDoc.setBaseDir(this.baseDir);
        HTMLDoc.setPathToDocument(pathToSourceDoc);

        return HTMLDoc;
    }


    
}
