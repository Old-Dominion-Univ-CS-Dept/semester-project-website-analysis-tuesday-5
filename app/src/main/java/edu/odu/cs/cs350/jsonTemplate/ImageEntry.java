package edu.odu.cs.cs350.jsonTemplate;

import java.util.List;

public class ImageEntry {
    private String name;
    private int numberOfPages;
    private List<String> pageListing;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<String> getPageListing() {
        return pageListing;
    }

    public void setPageListing(List<String> pageListing) {
        this.pageListing = pageListing;
    }
}

