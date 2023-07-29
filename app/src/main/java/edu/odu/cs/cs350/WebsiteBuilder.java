package edu.odu.cs.cs350;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.Files;
import java.util.List;



/**
 * This is a Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and obtains the website path and website url from each webpage. After obtaining all of that
 * information, it will build and return a website including its path and url.
 */


public class WebsiteBuilder {

    private Path path;
    private ArrayList<URL> urls;
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

/** Walk Directory function
 * @param thePath
 */

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

    /**
     * Removes Non HTML Files
     * @return
     */

    public List<Path> removeNonHTMLFiles()
    {
        return null;
    }

/**
 * builds website with path and url
 * @throws IOException
 * @return
 */

public Website build() throws IOException {

    List<Path> prunedFiles = removeNonHTMLFiles();

    ArrayList<HTMLDocument> parsedDocument = new ArrayList<>();
    for (Path htmlFile : prunedFiles) {
        FileReader html = new FileReader(htmlFile.toString());
        BufferedReader buffer = new BufferedReader(html);
        HTMLDocumentBuilder docBuilder = new HTMLDocumentBuilder();
        docBuilder.withContentFrom(buffer);
        docBuilder.withBaseDirectory(this.path);
        docBuilder.withBaseURLs(this.urls);
        docBuilder.extractContent();
        docBuilder.build();
        HTMLDocument doc = docBuilder.build();

        parsedDocument.add(doc);
    }

    Website site = new Website(this.path, this.urls, parsedDocument);

    return site;
    }

    }
