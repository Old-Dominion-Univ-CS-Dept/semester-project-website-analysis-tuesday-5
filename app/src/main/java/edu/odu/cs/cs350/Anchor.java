package edu.odu.cs.cs350;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;

public class Anchor {
    HTMLDocument foundOn;
    long sizeOfFile;
    Element content;
    Locality locality;

    enum Locality {
        Internal,
        External,
        Intrapage
    }

    /**
     * Empty constructor
     * 
     * @param none
     * 
     * @return none
     */
    public Anchor() {
        foundOn = null;
        content = null;
        locality = null;
    }

    /**
     * Anchor constructor
     * 
     * @param an Element
     * 
     * @return an Anchor object
     */
    public Anchor(Element anchorContent) {
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
        foundOn = found;
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
     * Mutator for the locality of the Anchor object
     * 
     * @param Locality enumerator
     * 
     * @return none
     */
    public void setLocality(Locality localityToBeSet) {
        locality = localityToBeSet;
    }

    /**
     * Accessor for locality
     * 
     * @param none
     * 
     * @return Locality enumerator
     */
    public Locality getLocality() {
        return locality;
    }

    /**
     * Mutator for foundOn member variable
     * 
     * @param HTMLDocument
     * 
     * @return none 
     */
    public void setFoundOn(HTMLDocument HTMLDoc) {
        foundOn = HTMLDoc;
    }

    /**
     * Accessor for the foundOn member variable
     * 
     * @param none
     * 
     * @return foundOn member variable
     */
    public HTMLDocument getFoundOn() {
        return foundOn;
    }
    
}