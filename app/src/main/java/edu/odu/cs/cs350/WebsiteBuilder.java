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
 * This is a Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and 
 *
 * 
 */


public class WebsiteBuilder {

public static Path withPath(String Path){

    Path path = jsoup.connect(Path).get();
    return path;
   

public static Document withURL(String URLs){
        
    Document doc = jsoup.connect(URL).get();
    return doc;
        
    }

public static Vector<Collection> withURLs(string URL){
        
    Vector<Collection> collect = new Vector<>();
    Vector<Collection> collect = jsoup.connect(URL).get();
    collect.add(URL)
    return collect:

}

public static void build(Website) {

    }
    
}
