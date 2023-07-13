package edu.odu.cs.cs350;

public class WebAnalysis {
        private String link;
         // Constructor
         public WebAnalysis(String link) {
            this.link = link;
        }
            //Getter
        public String getName() {
            return link;
        }

    public static void main(String[] args) {
        //driver -> wb: new()
        //return
        // Create a new WebAnalysis object
        WebAnalysis link = new WebAnalysis("John Doe");
        // Access the object's properties
        String name = link.getName();
        System.out.println("Name: " + name);



        //driver -> wb: withPath(path)
        //return


        //driver -> withURLs(urls)
        //return

        //driver -> wb: build()
        //    wb -> wb: walkDirectory()
    }

    
}
