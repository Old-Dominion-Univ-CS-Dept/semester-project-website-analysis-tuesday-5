package edu.odu.cs.cs350;

import org.jsoup.nodes.Element;

import edu.odu.cs.cs350.enums.ResourceKind;
import edu.odu.cs.cs350.htmlTag.Resource;

public class Image extends Resource {

    private Element content;
    private ResourceKind kind;

    /**
     * Empty constructor
     * 
     * @param none
     * 
     * @return none
     */
    public Image() {
        this.setKind(ResourceKind.IMAGE);
        this.setFoundOn(null);

    }

    /**
     * Image constructor
     * 
     * @param an Element
     * 
     * @return an Image object
     */
    public Image(Element ImageContent) {
        this.setKind(ResourceKind.IMAGE);
        content = ImageContent;
    }

    /**
     * Image constructor
     * 
     * @param an HTMLDocument object and an Element object
     * 
     * @return an Image object
     */
    public Image(HTMLDocument found, Element ImageContent) {
        this.addFoundOn(found);
        this.setKind(ResourceKind.IMAGE);
        content = ImageContent;
    }


    /**
     * An accessor for the content of an Image object
     * 
     * @param none
     * 
     * @return Element
     */
    public Element getContent() {
        return content;
    }


    /**
     * A mutator for the content of an Image Object
     * 
     * @param content
     * 
     * @return none
     */
    public void setContent(Element content) {
        this.content = content;
    }
}