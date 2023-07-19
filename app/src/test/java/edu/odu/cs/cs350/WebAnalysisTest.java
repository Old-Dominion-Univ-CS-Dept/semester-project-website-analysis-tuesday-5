package edu.odu.cs.cs350;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jsoup.Jsoup;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WebAnalysisTest {
    @Test
    @void GetPageTitle(){
        String html = "<html><head><title>Example Page Title</title></head><body></body></html>";
        Document doc = Jsoup.parse(html);

        String title = WebAnalysis.GetPageTitle(doc);
        assertEquals("Page Title", title);
    }
}
    

    
    
