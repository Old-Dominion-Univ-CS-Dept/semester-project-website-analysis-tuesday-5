package edu.odu.cs.cs350;




import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import edu.odu.cs.cs350.enums.Locality;

public class HTMLDocument {
    ArrayList<Anchor> anchors;
    ArrayList<Image> images;
    ArrayList<Script> scripts;
    ArrayList<StyleSheet> stylesheets;
    Document HTMLContent;
    Path baseDir;
    Path pathToDoc;
    ArrayList<HTMLDocument> foundOn;

    List<Resource> resources;
    long fileSize;
    String URL;

    String fileName;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }


    /**
     * Empty HTMLDocument Constructor.
     * 
     * @param none
     * 
     * @return HTMLDocument object
     */
    public HTMLDocument() {
        this.anchors = new ArrayList<>();
        
    }
 
    /**
     * HTMLdocument constructor
     * 
     * @param ArrayList of anchors
     * 
     * @return HTMLDocument object
     */
    public HTMLDocument(ArrayList<Anchor> extractedAnchors) {
        anchors = extractedAnchors;
    }

    public void setPathToDocument(Path path) {
        this.pathToDoc = path;
    }

    public void setBaseDir(Path path) {
        this.baseDir = path;
    }

    /**
     * Set anchors for an HTMLDocument
     * 
     * @param an HTMLDocument object and a list of Anchors
     * 
     * @return None
     */
    public void setAnchors(HTMLDocument HTMLDoc, ArrayList<Anchor> anchorList) {
        for(Anchor anchor: anchorList) {
            anchor.addFoundOn(HTMLDoc);
            anchors.add(anchor);
        }
    }

    /**
     * Accessor for anchors
     * 
     * @param none
     * 
     * @return Arraylist of Anchor objects
     */
    public ArrayList<Anchor> getAnchors() {
        return anchors;
    }

    public void setImages(HTMLDocument HTMLDoc, ArrayList<Image> imageList) {
        for(Image image: imageList) {
            image.addFoundOn(HTMLDoc);
            images.add(image);
        }
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setScripts(HTMLDocument HTMLDoc, ArrayList<Script> scriptList) {
        for(Script script: scriptList) {
            script.addFoundOn(HTMLDoc);
            scripts.add(script);
        }
}

    public ArrayList<Script> getScripts() {
        return scripts;
    }

    public void setStyleSheets(HTMLDocument HTMLDoc, ArrayList<StyleSheet> stylesheetList) {
        for(StyleSheet stylesheet: stylesheetList) {
            stylesheet.addFoundOn(HTMLDoc);
            stylesheets.add(stylesheet);
    }
}

    public ArrayList<StyleSheet> getstylesheets() {
        return stylesheets;
    }


    public void setHTMLContent(Document HTMLContent) {
        this.HTMLContent = HTMLContent;
    }

    public Document getHTMLContent() {
        return this.HTMLContent;
    }

    /**
     * Categorize anchors as either Internal, External, or Intra-page
     * 
     * @param none
     * 
     * @return none
     */
    public void categorizeAnchors() {
        for (Anchor anchor : anchors) {
            String stringifiedContent = anchor.getContent().toString();
            if (stringifiedContent.startsWith("http://") || stringifiedContent.startsWith("https://") || stringifiedContent.contains(":")) {
                anchor.setLocation(Locality.EXTERNAL);
                anchor.setUrl(stringifiedContent);
                
            
            } else if (anchor.getContent().nodeName().toString().startsWith("#")) {
                    anchor.setLocation(Locality.INTRAPAGE);
            } else {
                anchor.setLocation(Locality.INTERNAL);
            }
        } 
    }

}
