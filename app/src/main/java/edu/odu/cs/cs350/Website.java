package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Website {
    List<OtherFile> otherFiles;
    Path localDirectory;
    List<HTMLDocument> pages;

    public Website() {
        pages = new ArrayList<>();
    }

    public Website(Path localDirectory, List<HTMLDocument> pages) {
        this.localDirectory = localDirectory;
        this.pages = pages;
    }

    public List<OtherFile> getOtherFiles() {
        return otherFiles;
    }

    public void setOtherFiles(List<OtherFile> otherFiles) {
        this.otherFiles = otherFiles;
    }

    public void setLocalDirectory(Path localDirectory) {
        this.localDirectory = localDirectory;
    }

    public void addPage(HTMLDocument page) {
        pages.add(page);
    }

    public void setPages(List<HTMLDocument> pages) {
        this.pages = pages;
    }

    public Path getLocalDirectory() {
        return localDirectory;
    }

    public List<HTMLDocument> getPages() {
        return pages;
    }
}
