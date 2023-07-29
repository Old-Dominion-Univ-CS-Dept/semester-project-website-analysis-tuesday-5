package edu.odu.cs.cs350.htmlTag;

import edu.odu.cs.cs350.enums.Locality;
import edu.odu.cs.cs350.enums.ResourceKind;

import java.nio.file.Path;

public class Resource {
    private Path path;
    private String url;
    private Locality location;
    private ResourceKind kind;
    private long sizeOfFile;

    public Resource() {
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


}
