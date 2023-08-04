package edu.odu.cs.cs350;

import org.jsoup.nodes.Element;

import edu.odu.cs.cs350.enums.ResourceKind;

public class StyleSheet extends Resource {

    private Element content;
    private ResourceKind kind;

    /**
     * Empty constructor
     * 
     * @param none
     * 
     * @return none
     */
    public StyleSheet() {
        this.setKind(ResourceKind.STYLESHEET);
        this.setFoundOn(null);

    }

    
    /**
     * StyleSheet constructor
     * 
     * @param an Element
     * 
     * @return an StyleSheet object
     */
    public StyleSheet(Element StyleSheetContent) {
        this.setKind(ResourceKind.STYLESHEET);
        content = StyleSheetContent;
    }

    /**
     * StyleSheet constructor
     * 
     * @param an HTMLDocument object and an Element object
     * 
     * @return an StyleSheet object
     */
    public StyleSheet(HTMLDocument found, Element StyleSheetContent) {
        this.addFoundOn(found);
        this.setKind(ResourceKind.STYLESHEET);
        content = StyleSheetContent;
    }


    /**
     * An accessor for the content of an StyleSheet object
     * 
     * @param none
     * 
     * @return Element
     */
    public Element getContent() {
        return content;
    }


    /**
     * A mutator for the content of an StyleSheet Object
     * 
     * @param content
     * 
     * @return none
     */
    public void setContent(Element content) {
        this.content = content;
    }
}
