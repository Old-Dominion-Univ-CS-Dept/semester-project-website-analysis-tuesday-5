package edu.odu.cs.cs350;

import java.io.BufferedReader;
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
import java.util.Vector;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;



/**
 * This is a Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and obtains the website path and website url from each webpage. After obtaining all of that
 * information, it will build and return a website including its path and url.
 */


public class WebsiteBuilder {

    private Path path;
    private List<URL> urls;
    Path directoryToExamine;
    List<Path> allFiles;
    List<Path> allDirectories;


    /**
     * Default Constructor
     */

public WebsiteBuilder() {
    path = null;
    }

    /**
     * obtains website path
     * @param Path
     * @return
     * @throws IOException
     */
    
public static Document withPath(String Path) throws IOException{

    Document path = Jsoup.connect(Path).get();
    return path;
}

    /**
 * obtains website URL
 * @param URL
 * @return
 * @throws IOException
 */
    
public static Document withURL(String URL) throws IOException{
        
    Document doc = Jsoup.connect(URL).get();
    return doc;  
    }

    /**
 * obtains collection of website URLs
 * @param URL
 * @return
 */

public static ArrayList<URL> withURLs(URL URL){
        
    ArrayList<URL> collect = new ArrayList<URL>();
    collect.add(URL);
    return collect;
}

public void walkDirectory(Path thePath) {

    this.directoryToExamine = thePath;

    this.allFiles = new ArrayList<>();
    this.allDirectories = new ArrayList<>();

}

 /**
     * Examine this SimpleDirectoryWalker's specified directory of interest.
     *
     * @thorws IOException if directory could not be read
     */
    public void examineDirectory()
        throws IOException
    {
        Files.walk(this.directoryToExamine)
            .forEach((Path path) -> {
                if (Files.isRegularFile(path)) {
                    this.allFiles.add(path);
                }
                else if (Files.isDirectory(path)) {
                    this.allDirectories.add(path);
                }
            });
    }
/**
     * Retrieve the list of identified files.
     */
    public List<Path> getFileList()
    {
        return this.allFiles;
    }

    /**
     * Retrieve the list of identified directories.
     */
    public List<Path> getDirectoryList()
    {
        return this.allDirectories;
    }

    public List<Path> removeNonHTMLFiles()
    {
        return null;
    }

/**
 * builds website with path and url
 * @param website
 */

public Website build() throws IOException {

    List<Path> files = getFileList();
    List<Path> prunedFiles = removeNonHTMLFiles();

    ArrayList<HTMLDocument> parsedDocument = new ArrayList<>();
    for (Path htmlFile : prunedFiles) {
        WebsiteBuilder buffer = new WebsiteBuilder(/*...htmlFile... */);
        HTMLDocument doc = new HTMLDocumentBuilder()
        .withContentFrom(buffer)
        .withBaseDirectory(this.path)
        .withWebsiteURLs(this.urls)
        .extractContent()
        .build();

        parsedDocument.add(doc);
    }
    }

    }
