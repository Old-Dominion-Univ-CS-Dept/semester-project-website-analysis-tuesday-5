package edu.odu.cs.cs350;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;


public class WebAnalysisTest {
    

    @Test
    public void path_exists() throws IOException {
       Path link = ( "app/src/test/java/edu/odu/cs/cs350/SampleHTMLFile.html");
       assertThat(Files.exists(link)).isTrue;
    }
}
