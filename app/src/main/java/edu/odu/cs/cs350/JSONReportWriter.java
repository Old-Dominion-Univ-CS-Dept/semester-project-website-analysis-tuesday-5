package edu.odu.cs.cs350;

import static org.junit.Assert.*;



import com.cedarsoftware.util.io.JsonObject;
import com.cedarsoftware.util.io.JsonWriter;
import edu.odu.cs.cs350.HTMLDocument;
import edu.odu.cs.cs350.OtherFile;
import edu.odu.cs.cs350.Website;
import edu.odu.cs.cs350.enums.FileType;
import edu.odu.cs.cs350.enums.ResourceKind;
import edu.odu.cs.cs350.htmlTag.Anchor;
import edu.odu.cs.cs350.htmlTag.Resource;
import edu.odu.cs.cs350.htmlTag.Script;
import edu.odu.cs.cs350.htmlTag.*;
import edu.odu.cs.cs350.jsonTemplate.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
* JSON Report Writer class
*/

public class JSONReportWriter implements ReportWriter {
    private Website website;
    private String baseFileName;

    /**
    * Sets Source Data class
    @param website
    */

    @Override
    public void setSourceData(Website website) {
        this.website = website;
    }

    /**
    * Sets Base File Name function
    @param baseFileName
    */

    @Override
    public void setBaseName(String baseFileName) {
        this.baseFileName = baseFileName;

    }

    /** 
    *Gets website function
    @return website
    */

    @Override
    public Website getWebsite() {
        return website;
    }

    /**
    * Get Base File Name function
    @return baseFileName
    */

    @Override
    public String getBaseFileName() {
        return baseFileName;
    }

    /**
    * Write function
    */

    @Override
    public void write() {
        try {
            List<AudioFileEntry> audioFileEntries = new ArrayList<>();
            List<VideoFileEntry> videoFileEntries = new ArrayList<>();
            List<ArchiveFileEntry> archiveFileEntries = new ArrayList<>();
            List<ImageEntry> imageEntries = new ArrayList<>();
            List<PageEntry> pageEntries = new ArrayList<>();
            List<NonCategorizedFileEntry> nonCategorizedFileEntries = new ArrayList<>();

            for (OtherFile otherFile : website.getOtherFiles()) {
                if (otherFile.getFileType().equals(FileType.AUDIO)) {

                    AudioFileEntry audioFileEntry = new AudioFileEntry();
                    audioFileEntry.setResourcePath(otherFile.getPath().toString());
                    audioFileEntry.setFileSize(otherFile.getFileSize());
                    audioFileEntries.add(audioFileEntry);

                } else if (otherFile.getFileType().equals(FileType.VIDEO)) {

                    VideoFileEntry videoFileEntry = new VideoFileEntry();
                    videoFileEntry.setResourcePath(otherFile.getPath().toString());
                    videoFileEntry.setFileSize(otherFile.getFileSize());
                    videoFileEntries.add(videoFileEntry);

                } else if (otherFile.getFileType().equals(FileType.ARCHIVE)) {

                    ArchiveFileEntry archiveFileEntry = new ArchiveFileEntry();
                    archiveFileEntry.setResourcePath(otherFile.getPath().toString());
                    archiveFileEntry.setFileSize(otherFile.getFileSize());
                    archiveFileEntries.add(archiveFileEntry);

                } else if (otherFile.getFileType().equals(FileType.UNCATEGORIZED)) {

                    NonCategorizedFileEntry nonCategorizedFileEntry = new NonCategorizedFileEntry();
                    nonCategorizedFileEntry.setResourcePath(otherFile.getPath().toString());
                    nonCategorizedFileEntry.setFileSize(otherFile.getFileSize());
                    nonCategorizedFileEntries.add(nonCategorizedFileEntry);
                } else if (otherFile.getFileType().equals(FileType.IMAGE)) {
                    List<String> pages = new ArrayList<>();
                    int imageCount = 0;

                    for (HTMLDocument page : website.getPages()) {
                        for (Resource resource : page.getResources()) {
                            if (resource instanceof Image && resource.getKind().equals(ResourceKind.IMAGE)) {
                                Image image = (Image) resource;
                                if (otherFile.getPath().endsWith(String.valueOf(image.getPath()))) {
                                    imageCount++;
                                    pages.add(page.getFileName());
                                }
                            }
                        }
                    }

                    ImageEntry imageEntry = new ImageEntry();
                    String fileName = Paths.get(otherFile.getPath()).getFileName().toString();
                    imageEntry.setName(fileName);
                    imageEntry.setNumberOfPages(imageCount);
                    imageEntry.setPageListing(pages);
                    imageEntries.add(imageEntry);
                }
            }

            for (HTMLDocument page : website.getPages()) {
                PageEntry pageEntry = new PageEntry();
                pageEntry.setLocalImages(0);
                pageEntry.setExternalImages(0);
                pageEntry.setScriptsReferenced(0);
                pageEntry.setStylesheetsUtilized(0);
                pageEntry.setImageListing(new ArrayList<>());
                pageEntry.setScriptListing(new ArrayList<>());
                pageEntry.setStylesheetListing(new ArrayList<>());
                pageEntry.setIntraPageLinks(0);
                pageEntry.setInterSiteLinks(0);
                pageEntry.setExternalLinks(0);

                for (Resource resource : page.getResources()) {
                    pageEntry.setPageName(page.getFileName());
                    if (resource instanceof Image) {
                        Image image = (Image) resource;
                        String src = image.getPath().toString();
                        if (src.startsWith("/") || src.startsWith("http://") || src.startsWith("https://")) {
                            pageEntry.setExternalLinks(pageEntry.getExternalLinks() + 1);
                            pageEntry.getImageListing().add(image.getPath().toString());
                        } else {
                            pageEntry.setLocalImages(pageEntry.getLocalImages() + 1);
                            pageEntry.getImageListing().add(image.getPath().toString());
                        }
                    } else if (resource instanceof Script) {
                        pageEntry.setScriptsReferenced(pageEntry.getScriptsReferenced() + 1);
                        pageEntry.getScriptListing().add(resource.getPath().toString());
                    } else if (resource instanceof StyleSheet) {
                        pageEntry.setStylesheetsUtilized(pageEntry.getStylesheetsUtilized() + 1);
                        pageEntry.getScriptListing().add(resource.getPath().toString());

                    } else if (resource instanceof Anchor) {
                        if (resource.getUrl().contains("#")) {
                            pageEntry.setIntraPageLinks(pageEntry.getIntraPageLinks() + 1);
                        } else if (resource.getUrl().contains("http")) {
                            pageEntry.setExternalLinks(pageEntry.getExternalLinks() + 1);
                        } else {
                            pageEntry.setInterSiteLinks(pageEntry.getInterSiteLinks() + 1);
                        }
                    }
                }
                pageEntries.add(pageEntry);
            }
            JsonObject wrapperObject = new JsonObject();
            wrapperObject.put("Pages", pageEntries);
            wrapperObject.put("Image Files", imageEntries);
            wrapperObject.put("Archive Files", archiveFileEntries);
            wrapperObject.put("Video Files", videoFileEntries);
            wrapperObject.put("Audio Files", audioFileEntries);
            wrapperObject.put("Uncategorized Files", nonCategorizedFileEntries);


            String json = JsonWriter.objectToJson(wrapperObject);

            // Write JSON to file
            String fileName = baseFileName + "-summary.json";
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(json);
            fileWriter.close();

            System.out.println("JSON report generated: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
