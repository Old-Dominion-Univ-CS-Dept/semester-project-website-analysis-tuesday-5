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
 * information, it will build and return a website.
 */


public class WebsiteBuilder {

    /**
    * obtains website path
    */
    
public static Path withPath(String Path){

    Path path = jsoup.connect(Path).get();
    return path;
}
   
/**
* obtains website URL
*/
    
public static Document withURL(String URLs){
        
    Document doc = Jsoup.connect(URL).get();
    return doc;
        
    }
    
/**
* obtains collection of website URLs
*/
    
public static Vector<Collection> withURLs(string URL){
        
    Vector<Collection> collect = new Vector<>();
    Vector<Collection> collect = jsoup.connect(URL).get();
    collect.add(URL)
    return collect:

}

    /**
    * builds website with path and url
    */

public static void build(Website) {

    }
    
}
