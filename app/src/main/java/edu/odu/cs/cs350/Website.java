package edu.odu.cs.cs350;

import java.util.Collection;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Vector;
import java.nio.file.Path;


public class Website {

Vector<Element> URL;
static String Path;

public Website(Vector<Element> Url, String path) {
    URL = Url;
    Path = path;
}

public void setPath(String path) {
    Path = path;
}

///public static Path getPath() {
 ///   return Path;
///}


public void setUrl(Vector<Element> Url) {
    URL = Url;
}

public static URL getURL(java.net.URL Url) {
    return Url;
}
    
}
