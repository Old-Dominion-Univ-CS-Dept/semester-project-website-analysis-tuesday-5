package edu.odu.cs.cs350;

import java.util.ArrayList;
import org.jsoup.nodes.Element;

public class HTMLDocument {
    ArrayList<Element> anchors;
 
    public HTMLDocument(ArrayList<Element> extractedAnchors) {
        anchors = extractedAnchors;
    }

    public void setAnchors(ArrayList<Element> anchorList) {
        anchors = anchorList;
    }

    public ArrayList<Element> getAnchors() {
        return anchors;
    }
}
