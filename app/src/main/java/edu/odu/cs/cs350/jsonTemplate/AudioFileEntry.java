package edu.odu.cs.cs350.jsonTemplate;

public class AudioFileEntry {
    private long fileSize;
    private String resourcePath;

    public AudioFileEntry() {
    }

    public AudioFileEntry(long fileSize, String resourcePath) {
        this.fileSize = fileSize;
        this.resourcePath = resourcePath;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }
}
