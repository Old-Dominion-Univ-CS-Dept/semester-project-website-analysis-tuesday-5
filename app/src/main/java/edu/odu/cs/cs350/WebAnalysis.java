package edu.odu.cs.cs350;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
//This is WebAnalysis the driver class for WB (WebsiteBuilder) where it will fetch the path and URL 
//of the given directory
public class WebAnalysis  {
    public static void main(String[] args) {

        //Will handle user arguments 
        String webPath = args[0];

        List<String> urls = Arrays.stream(args)
            .skip(1)
            .collect()
            .toList();

        Website site = new WebsiteBuilder();
            .withPath()
            .withURLs(urls)
            .build();

            ReportManager manager = new ReportManager();
            manager.setSourceData(site);
            manager.determineBaseFilename();
            manager.writeAll();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            manager.writeReportNames(writer);

        

        //driver -> wb: new()
        //return
        //The method withPath(String) in the type WebsiteBuilder is not applicable for the arguments ()
        //The constructor WebsiteBuilder(Path) is undefined
       // WebsiteBuilder WB = new WebsiteBuilder(pathToAnalysis);
        //WB.withPath();

             //driver -> wb: withPath(path)
            //return
        //System.out.println("Path Identifed: ");
        //for (Path file : WB.withPath()){
           // System.out.format("  -%s%n", file);
       // }
       // System.out.println();

            //driver -> wb: withURLs(urls)
            //return
            //The method withURL(String) in the type WebsiteBuilder is not applicable for the arguments ()
       // System.out.println("URLs Identified: ");
        //for (Path file : WB.withURLs()){
      //      System.out.format("  - %s%n", file);
       // }

        //driver -> wb: build()
       // Stream.Builder<String> builder = Stream.builder();
        //Stream<String> str = builder.build();
       // str.forEach(System.out::println);
    }
}    
    
   
