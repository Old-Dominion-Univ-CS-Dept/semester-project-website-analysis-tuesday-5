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

    public Resource() {
        this.foundOn = new ArrayList<>();
    }


    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Locality getLocation() {
        return location;
    }

    public void setLocation(Locality location) {
        this.location = location;
    }

    public ResourceKind getKind() {
        return kind;
    }

    public void setKind(ResourceKind kind) {
        this.kind = kind;
    }

    public long getSizeOfFile() {
        return sizeOfFile;
    }

    public void setSizeOfFile(long sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    public void setFoundOn(ArrayList<HTMLDocument> foundOnList) {
        this.foundOn = foundOnList;
    }

    public ArrayList<HTMLDocument> getFoundOn() {
        return foundOn;
    }

    public void addFoundOn(HTMLDocument HTMLDoc) {
        this.foundOn.add(HTMLDoc);
    }


} 
