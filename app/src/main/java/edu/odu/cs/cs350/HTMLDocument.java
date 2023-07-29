package edu.odu.cs.cs350;




import java.nio.file.Path;
import java.util.ArrayList;

import org.jsoup.nodes.Document;

import edu.odu.cs.cs350.enums.Locality;

public class HTMLDocument {
    ArrayList<Anchor> anchors;
    Document HTMLContent;
    Path baseDir;

    /**
     * Empty HTMLDocument Constructor.
     * 
     * @param none
     * 
     * @return HTMLDocument object
     */
    public HTMLDocument() {
        anchors = null;
        
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
            }

            //Pattern pattern = Pattern.compile("#");
            //Matcher matcher = pattern.matcher(anchor.getContent().toString());
            //if(matcher.find()) {
            //    anchor.setLocation(Locality.INTRAPAGE);
            //}
        }

    }
}
