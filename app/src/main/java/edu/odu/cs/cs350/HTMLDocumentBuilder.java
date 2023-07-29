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
 * images, stylesheets, JavaScript code) from each webpage. After extracting all of that
 * information, it will build and return an HTML Document.
 */
public class HTMLDocumentBuilder {

    Path baseDir;
    //ArrayList<Path> webPages;
    //ArrayList<Path> directories;
    private ArrayList<URL> baseUrls;

    private ArrayList<Anchor> anchors;
    private ArrayList<Resource> images;
    private ArrayList<Resource> scripts;
    private ArrayList<Resource> stylesheets;

    private Document HTMLDocumentContent;


    ArrayList<Anchor> extractedAnchors = new ArrayList<Anchor>();

    public HTMLDocumentBuilder() {
        this.anchors = new ArrayList<>();
        this.images = new ArrayList<>();
        this.scripts = new ArrayList<>();
        this.stylesheets = new ArrayList<>();
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
        this.baseDir = Paths.get(file).normalize();
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
    

    public void withBaseDirectory(Path siteRoot) throws IOException {
        this.baseDir = siteRoot;
        /*this.webPages = new ArrayList<>();
        this.directories = new ArrayList<>();

        Files.walk(siteRoot)
            .forEach((Path path) -> {
                if (Files.isRegularFile(path)) {
                    this.webPages.add(path);
                }
                else if (Files.isDirectory(path)) {
                    this.directories.add(path);
                }
            }); */

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

    /*
    public ArrayList<Path> getWebPages() {
        return this.webPages;
    }

    public ArrayList<Path> getDirectories() {
        return this.directories;
    }
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
     * Accessor for ArrayList of Anchors
     * 
     * @param none
     * 
     * @return anchors ArrayList
     */
    public ArrayList<Anchor> getAnchors() {
        return anchors;
    }

    public void extractContent() throws IOException {
        this.extractAnchors();
    }


    /**
     * Builds a completed HTMLDocument object
     * 
     * @param None
     * 
     * @return an HTMLDocument object
     */
    public HTMLDocument build() {
        HTMLDocument HTMLDoc = new HTMLDocument();
        HTMLDoc.setHTMLContent(HTMLDocumentContent);
        HTMLDoc.setAnchors(HTMLDoc, anchors);

        return HTMLDoc;
    }


    
}
