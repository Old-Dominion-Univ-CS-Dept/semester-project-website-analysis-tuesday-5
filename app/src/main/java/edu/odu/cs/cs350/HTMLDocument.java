package edu.odu.cs.cs350;




import java.util.List;

public class HTMLDocument {
    List<Resource> resources;
    long fileSize;

    String fileName;

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

import java.util.ArrayList;
import org.jsoup.nodes.Element;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLDocument {
    enum Locality {
        Internal,
        External,
        IntraPage
    }
    ArrayList<Anchor> anchors;
    Locality locality;

    /**
     * Empty HTMLDocument Constructor.
     * 
     * @param none
     * 
     * @return HTMLDocument object
     */
    public HTMLDocument() {
        anchors = null;
        locality = null;
        
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

    /**
     * Set anchors for an HTMLDocument
     * 
     * @param an HTMLDocument object and a list of Anchors
     * 
     * @return None
     */
    public void setAnchors(HTMLDocument HTMLDoc, ArrayList<Anchor> anchorList) {
        for(Anchor anchor: anchorList) {
            anchor.setFoundOn(HTMLDoc);
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

    /**
     * Categorize anchors as either Internal, External, or Intra-page
     * 
     * @param none
     * 
     * @return none
     */
    public void categorizeAnchors() {
        for (Anchor anchor : anchors) {
            Pattern pattern = Pattern.compile("#");
            Matcher matcher = pattern.matcher(anchor.getContent().toString());
            if(matcher.find()) {
                locality = Locality.IntraPage;
            }
        }

    }
}
