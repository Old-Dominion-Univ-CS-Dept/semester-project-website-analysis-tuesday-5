package edu.odu.cs.cs350;

import org.jsoup.nodes.Element;

import edu.odu.cs.cs350.enums.ResourceKind;

public class Anchor extends Resource {

    private Element content;

    /**
     * Empty constructor
     * 
     * @param none
     * 
     * @return none
     */
    public Anchor() {
        this.setKind(ResourceKind.ANCHOR);
        this.setFoundOn(null);
    }

    /**
     * Anchor constructor
     * 
     * @param an Element
     * 
     * @return an Anchor object
     */
    public Anchor(Element anchorContent) {
        this.setKind(ResourceKind.ANCHOR);
        content = anchorContent;
    }

    /**
     * Anchor constructor
     * 
     * @param an HTMLDocument object and an Element object
     * 
     * @return an Anchor object
     */
    public Anchor(HTMLDocument found, Element anchorContent) {
        this.addFoundOn(found);
        this.setKind(ResourceKind.ANCHOR);
        content = anchorContent;
    }


    /**
     * An accessor for the content of an Anchor object
     * 
     * @param none
     * 
     * @return Element
     */
    public Element getContent() {
        return content;
    }


    /**
     * A mutator for the content of an Anchor Object
     * 
     * @param content
     * 
     * @return none
     */
    public void setContent(Element content) {
        this.content = content;
    }
    
}