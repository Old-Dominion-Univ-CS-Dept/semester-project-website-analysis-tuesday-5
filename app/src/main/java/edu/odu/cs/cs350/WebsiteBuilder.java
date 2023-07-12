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
 * This is a Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and 
 *
 * @author Jon Rossy
 */


public class WebsiteBuilder {

public static void withPath(path: Path){
        
    }

public static Document withURL(String URL){
        Document doc = jsoup.connect(URL).get();
    return doc;
        
    }

public static Collection<?> withURLs(urls: Collection<?>){
        Collection<?> collect = jsoup.connect(URL).get();
   return collect;


}

public static void build(Website) {

    }
    
}
