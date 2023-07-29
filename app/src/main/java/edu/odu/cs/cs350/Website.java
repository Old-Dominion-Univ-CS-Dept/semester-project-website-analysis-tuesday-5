package edu.odu.cs.cs350;
import java.net.URL;
import java.util.ArrayList;
import java.nio.file.Path;


/** 
 * Website class also used for Website builder
 */
public class Website {

ArrayList<URL> URL;
static Path Path;

    /**
 * Function for website URL and path
 * @param urls
 * @param path
 * @param parsedDocument
 */
public Website(Path path, ArrayList<URL> urls, ArrayList<HTMLDocument> parsedDocument) {
    URL = urls;
    Path = path;
}

    /**
 * Sets website path
 * @param path
 */
public void setPath(Path path) {
    Path = path;
}

/** Gets Website path
 */

public static Path getPath() {
    return Path;
}

    /**
 * Sets website url
 * @param urls
 */
public void setUrl(ArrayList<URL> urls) {
    URL = urls;
}

    /**
 * Gets website url
 * @return
 */
public ArrayList<URL> getURL() {
    return URL;
}
    
}

