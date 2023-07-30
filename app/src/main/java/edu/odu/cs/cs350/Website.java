package edu.odu.cs.cs350;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** 
 * Website class also used for Website builder
 */

public class Website {
    List<OtherFile> otherFiles;
    Path localDirectory;
    List<HTMLDocument> pages;

     /**
 * Default constructor
 */

    public Website() {
        pages = new ArrayList<>();
    }

 /**
 * Function for website URL and path
 * @param localDirectory
 * @param pages
 */

    public Website(Path localDirectory, List<HTMLDocument> pages) {
        this.localDirectory = localDirectory;
        this.pages = pages;
    }

    /**
    * Get other types of files (HTML, CSS, Image(PNG), Image(JPG), plaintext, zip files, quicktime videos, mp4 videos, pdf, audio) function
    * @return
    */

    public List<OtherFile> getOtherFiles() {
        return otherFiles;
    }

    /** 
    * sets other types of files (HTML, CSS, Image(PNG), Image(JPG), plaintext, zip files, quicktime videos, mp4 videos, pdf, audio) function
    */

    public void setOtherFiles(List<OtherFile> otherFiles) {
        this.otherFiles = otherFiles;
    }

    /** 
    * sets local directory function
    */

    public void setLocalDirectory(Path localDirectory) {
        this.localDirectory = localDirectory;
    }

    /** 
    * adds an html document page function
    * @param page
    */

    public void addPage(HTMLDocument page) {
        pages.add(page);
    }

    /**
    * sets an html document function
    * @param pages
    */

    public void setPages(List<HTMLDocument> pages) {
        this.pages = pages;
    }

    /**
    * gets a local directory function
    * @return
    */

    public Path getLocalDirectory() {
        return localDirectory;
    }

    /**
    * gets an html document function
    * @return
    */

    public List<HTMLDocument> getPages() {
        return pages;
    }
}
