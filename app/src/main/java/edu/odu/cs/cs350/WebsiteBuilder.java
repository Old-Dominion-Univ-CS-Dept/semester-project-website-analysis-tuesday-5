package edu.odu.cs.cs350;

import java.util.Collection;

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
