package edu.odu.cs.cs350;

import org.jsoup.nodes.Element;

import edu.odu.cs.cs350.enums.ResourceKind;

public class Script extends Resource {

    private Element content;
    private ResourceKind kind;

    /**
     * Empty constructor
     * 
     * @param none
     * 
     * @return none
     */
    public Script() {
        this.setKind(ResourceKind.SCRIPT);
        this.setFoundOn(null);

    }

    /**
     * Script constructor
     * 
     * @param an Element
     * 
     * @return an Script object
     */
    public Script(Element ScriptContent) {
        this.setKind(ResourceKind.SCRIPT);
        content = ScriptContent;
    }

    /**
     * Script constructor
     * 
     * @param an HTMLDocument object and an Element object
     * 
     * @return an Script object
     */
    public Script(HTMLDocument found, Element ScriptContent) {
        this.addFoundOn(found);
        this.setKind(ResourceKind.SCRIPT);
        content = ScriptContent;
    }


    /**
     * An accessor for the content of an Script object
     * 
     * @param none
     * 
     * @return Element
     */
    public Element getContent() {
        return content;
    }


    /**
     * A mutator for the content of an Script Object
     * 
     * @param content
     * 
     * @return none
     */
    public void setContent(Element content) {
        this.content = content;
    }
}