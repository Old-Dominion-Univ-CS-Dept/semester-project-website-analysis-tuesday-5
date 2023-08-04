package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.ArrayList;

import edu.odu.cs.cs350.enums.Locality;
import edu.odu.cs.cs350.enums.ResourceKind;

public class Resource {
    private Path path;
    private String url;
    private Locality location;
    private ResourceKind kind;
    private long sizeOfFile;
    private ArrayList<HTMLDocument> foundOn;

    /**
    * Resource function
    */

    public Resource() {
        this.foundOn = new ArrayList<>();
    }

    /**
    * Gets path function
    @return path
    */

    public Path getPath() {
        return path;
    }

    /**
    * Sets path function
    @param path
    */

    public void setPath(Path path) {
        this.path = path;
    }

    /** 
    * Gets website url function
    @return url
    */

    public String getUrl() {
        return url;
    }

    /** 
    * Sets website url function
    @param url
    */

    public void setUrl(String url) {
        this.url = url;
    }

    /** 
    * Gets website location function
    @return location
    */

    public Locality getLocation() {
        return location;
    }

    /** 
    * Set website location function
    @param location
    */

    public void setLocation(Locality location) {
        this.location = location;
    }

    /**
    * Get Kind function
    @return kind
    */

    public ResourceKind getKind() {
        return kind;
    }

    /**
    * Set kind function
    @param kind
    */

    public void setKind(ResourceKind kind) {
        this.kind = kind;
    }

    /**
    * Gets size of file function
    @return sizeOfFile
    */

    public long getSizeOfFile() {
        return sizeOfFile;
    }

    /**
    * Sets Size of File function
    @param sizeOfFile
    */

    public void setSizeOfFile(long sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    /** 
    *Set Found on function
    @param foundOnList
    */

    public void setFoundOn(ArrayList<HTMLDocument> foundOnList) {
        this.foundOn = foundOnList;
    }

    /**
    * Get Found On function
    @return foundOn
    */

    public ArrayList<HTMLDocument> getFoundOn() {
        return foundOn;
    }

    /**
    * Add Found On function
    @param HTMLDoc
    */

    public void addFoundOn(HTMLDocument HTMLDoc) {
        this.foundOn.add(HTMLDoc);
    }


} 
