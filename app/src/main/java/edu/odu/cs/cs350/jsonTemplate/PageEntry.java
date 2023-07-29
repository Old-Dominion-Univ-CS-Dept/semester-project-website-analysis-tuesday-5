package edu.odu.cs.cs350.jsonTemplate;

import java.util.List;

public class PageEntry {
    private String pageName;
    private int localImages;
    private int externalImages;
    private int scriptsReferenced;
    private int stylesheetsUtilized;
    private List<String> imageListing;
    private List<String> scriptListing;
    private List<String> stylesheetListing;
    private int intraPageLinks;
    private int interSiteLinks;
    private int externalLinks;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getLocalImages() {
        return localImages;
    }

    public void setLocalImages(int localImages) {
        this.localImages = localImages;
    }

    public int getExternalImages() {
        return externalImages;
    }

    public void setExternalImages(int externalImages) {
        this.externalImages = externalImages;
    }

    public int getScriptsReferenced() {
        return scriptsReferenced;
    }

    public void setScriptsReferenced(int scriptsReferenced) {
        this.scriptsReferenced = scriptsReferenced;
    }

    public int getStylesheetsUtilized() {
        return stylesheetsUtilized;
    }

    public void setStylesheetsUtilized(int stylesheetsUtilized) {
        this.stylesheetsUtilized = stylesheetsUtilized;
    }

    public List<String> getImageListing() {
        return imageListing;
    }

    public void setImageListing(List<String> imageListing) {
        this.imageListing = imageListing;
    }

    public List<String> getScriptListing() {
        return scriptListing;
    }

    public void setScriptListing(List<String> scriptListing) {
        this.scriptListing = scriptListing;
    }

    public List<String> getStylesheetListing() {
        return stylesheetListing;
    }

    public void setStylesheetListing(List<String> stylesheetListing) {
        this.stylesheetListing = stylesheetListing;
    }

    public int getIntraPageLinks() {
        return intraPageLinks;
    }

    public void setIntraPageLinks(int intraPageLinks) {
        this.intraPageLinks = intraPageLinks;
    }

    public int getInterSiteLinks() {
        return interSiteLinks;
    }

    public void setInterSiteLinks(int interSiteLinks) {
        this.interSiteLinks = interSiteLinks;
    }

    public int getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(int externalLinks) {
        this.externalLinks = externalLinks;
    }
}

