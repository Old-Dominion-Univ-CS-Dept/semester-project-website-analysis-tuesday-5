package edu.odu.cs.cs350;
import java.nio.file.Path;
import edu.odu.cs.cs350.WebsiteBuilder;
public class WebAnalysis {
    public String Path;
    public String URLs;
    public String URL;

    public WebsiteBuilder(String Path);{
        this.Path = Path;
    }
    public WebsiteBuilder(String URLs) {
        this.URLs = URLs;
    }
    
    public static void main(String[] args) {
       //driver -> wb: new()
      //return 
        WebsiteBuilder Path = new WebsiteBuilder("/path/to/website");
            //driver -> wb: withPath(path)
            //return
        WebsiteBuilder Document = new WebsiteBuilder(URLs);
        Document.build();
        WebsiteBuilder updatedDocment = Document.withPath(Path);
        updatedDocment.build();
            //driver -> wb: withURLs(urls)
            //return
        List<String> urls = Arrays.asList("https://example.com", "https://example.org");
        WebsiteBuilder = WebsiteBuilder.withURLs(URL);
    }
   //driver -> wb: build()
   public void build(WebsiteBuilder) {
    // Build the website using the specified path
    System.out.println("Building website at path: " + Path);
}
  


}