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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Vector;
import java.nio.file.Path;

/**
 * This is a Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and obtains the website path and website url from each webpage. After obtaining all of that
 * information, it will build and return a website including its path and url.
 */


public class WebsiteBuilder {

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

public static Vector<Element> withURLs(Element URL){
        
    Vector<Element> collect = new Vector<>();
    collect.add(URL);
    return collect;
}

/**
 * builds website with path and url
 * @param website
 */
    
public static void build(Website website) {

    }
}
