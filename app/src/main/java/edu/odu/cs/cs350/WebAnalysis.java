package edu.odu.cs.cs350;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.nio.file.Path;
import edu.odu.cs.cs350.WebsiteBuilder;

public class WebAnalysis extends WebsiteBuilder {
    public static void main(String[] args) {
       //driver -> wb: new()
      //return 
        WebsiteBuilder path = new WebsiteBuilder();
            return;
            try{
                //Connenct to the web page and get the HTML document
                Document doc = Jsoup.connect(URL).get();

                //Print the page title 
                String title = doc.title();
                System.out.println("Page title: " + title);

                // Print all the links in the page
                System.out.println("Links: ");
                Element links = doc.select("a[href]");
                for(Element link : links){
                    String href = link.attr("href");
                    System.out.println(href);
                }
            }
            
            //driver -> wb: withPath(path)
            //return
      
            //driver -> wb: withURLs(urls)
            //return
    }
   //driver -> wb: build()
}