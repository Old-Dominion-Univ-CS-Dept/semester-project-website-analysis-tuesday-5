package edu.odu.cs.cs350;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
    ArrayList<Path> webPages;
    ArrayList<Path> directories;
    private ArrayList<URL> baseUrls;

    private ArrayList<Resource> anchors;
    private ArrayList<Resource> images;
    private ArrayList<Resource> scripts;
    private ArrayList<Resource> stylesheets;


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
    public static Document withContentFrom(StringBuffer reader) {
        return Jsoup.parse(reader.toString());

    }
    
    
    public void withContentFrom(String file) 
        throws IOException 
    {

        Path filePath = Paths.get(file);
        this.webPages.add(filePath);
    }
    

    public void withBaseDirectory(Path siteRoot) throws IOException {
        this.baseDir = siteRoot;
        this.webPages = new ArrayList<>();
        this.directories = new ArrayList<>();

        Files.walk(siteRoot)
            .forEach((Path path) -> {
                if (Files.isRegularFile(path)) {
                    this.webPages.add(path);
                }
                else if (Files.isDirectory(path)) {
                    this.directories.add(path);
                }
            });

    }

    public ArrayList<Path> getWebPages() {
        return this.webPages;
    }

    public ArrayList<Path> getDirectories() {
        return this.directories;
    }


    public static void withBaseURLs(ArrayList<URL> URLs) {
        for (URL iterURL : URLs) {
            String stringifiedURL = iterURL.toString();
            if (stringifiedURL.startsWith("http://") || stringifiedURL.startsWith("https://") || stringifiedURL.contains(":")) {
                
            }
        }
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
        Elements links = doc.select("a");
        links.attr("href");
        for (Element link : links) {
            Element linkHref = new Element(link.attr("href"));
            Anchor a = new Anchor(linkHref);
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
