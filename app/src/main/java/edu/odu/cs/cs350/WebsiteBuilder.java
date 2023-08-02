package edu.odu.cs.cs350;
import edu.odu.cs.cs350.enums.FileType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a Website Parser that takes a path to a website and either/or a single website url or a collection of website urls and obtains the website path and website url from each webpage. After obtaining all of that
 * information, it will build and return a website including its path and url.
 */

public class WebsiteBuilder {
    private Path path;
    private HTMLDocumentBuilder htmlDocumentBuilder;

    private int htmlCounter,
            cssCounter,
            imageryCounter,
            jsCounter,
            archivesCounter,
            videosCounter,
            audioCounter,
            uncategorizedCounter;

    /**
     * Default Constructor
     * @param path
     * @return
     */
    
    public WebsiteBuilder withPath(Path path) {
        this.path = path;
        return this;
    }

    /**
 * builds website with path and url
 * @return
 */

    public Website build() {
        HTMLDocument htmlDocument = null;
        if (htmlDocumentBuilder != null) {
            htmlDocument = htmlDocumentBuilder.build();
        }
        return new Website();
    }

    /** Walk Directory function
 * @param directory
 * @throws IOException
 * @return
 */

    public List<Path> walkDirectory(Path directory) throws IOException {
        List<Path> htmlFiles = new ArrayList<>();

        // Traverse the directory and collect HTML files
        Files.walk(directory)
                .filter(file -> Files.isRegularFile(file))
                .forEach(htmlFiles::add);
        return htmlFiles;
    }

     /**
     * Removes Non HTML Files
     * @param files
     * @return
     */

    public List<Path> removeNonHTMLFiles(List<Path> files) {
        List<Path> htmlFiles = files.stream()
                .filter(file -> file.toString().endsWith(".html"))
                .collect(Collectors.toList());

        if (htmlFiles.isEmpty()) {
            System.err.println("Error: The site contains zero HTML pages. Analysis cannot proceed.");
            System.exit(1);
        } else if (htmlFiles.size() > 1000) {
            System.out.println("Warning: The site contains more than 1,000 pages. Analysis is not recommended for large sites.");
        }
        return htmlFiles;
    }

    /**
    * Extracts other files (HTML, CSS, Image(PNG), Image(JPG), plaintext, zip files, quicktime videos, mp4 videos, pdf, audio
    * @param files
    */

    public List<OtherFile> extractOtherFiles(List<Path> files) throws IOException {
        List<OtherFile> otherFiles = new ArrayList<>();
        for (Path file : files) {
            String name = Files.probeContentType(file);
            switch (name) {
                case "text/html":
                    System.out.print("HTML file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    htmlCounter++;
                    break;
                case "text/css":
                    System.out.print("CSS file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile css = new OtherFile(name, "CSS", Files.size(file), file.toFile().getPath(), FileType.CSS);
                    otherFiles.add(css);
                    cssCounter++;
                    break;
                case "image/png":
                    System.out.print("Image(PNG) file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile image = new OtherFile(name, "PNG", Files.size(file), file.toFile().getPath(), FileType.IMAGE);
                    otherFiles.add(image);
                    imageryCounter++;
                    break;
                case "image/jpeg":
                    System.out.print("Image(JPG) file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile imageJPEG = new OtherFile(name, "JPG", Files.size(file), file.toFile().getPath(), FileType.IMAGE);
                    otherFiles.add(imageJPEG);
                    imageryCounter++;
                    break;
                case "text/plain":
                    System.out.print("Text/Plain read as JS file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile js = new OtherFile(name, "JS", Files.size(file), file.toFile().getPath(), FileType.JS);
                    otherFiles.add(js);
                    jsCounter++;
                    break;
                case "application/x-zip-compressed":
                    System.out.print("Zip(Archive) file file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile zip = new OtherFile(name, "ZIP", Files.size(file), file.toFile().getPath(), FileType.ARCHIVE);
                    otherFiles.add(zip);
                    archivesCounter++;
                    break;
                case "video/quicktime":
                case "video/mp4":
                    System.out.print("Video(.mov/.mp4) file found and added:");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile video = new OtherFile(name, "Video", Files.size(file), file.toFile().getPath(), FileType.VIDEO);
                    otherFiles.add(video);
                    videosCounter++;
                    break;
                case "application/pdf":
                    System.out.println("PDF file set as Uncategorized file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile pdf = new OtherFile(name, "PDF", Files.size(file), file.toFile().getPath(), FileType.UNCATEGORIZED);
                    otherFiles.add(pdf);
                    uncategorizedCounter++;
                    break;
                case "audio/mpeg":
                    System.out.print("Audio file found and added: ");
                    System.out.println(file.getFileName());
                    System.out.println("file path: " + file.toFile().getPath());
                    OtherFile audio = new OtherFile(name, "Audio", Files.size(file), file.toFile().getPath(), FileType.AUDIO);
                    otherFiles.add(audio);
                    audioCounter++;
                    break;
            }
        }
        System.out.println("HTML: " + htmlCounter + " CSS:" + cssCounter + " JS:" + jsCounter + " Images:" + imageryCounter +
                " Archives:" + archivesCounter + " Audio:" + audioCounter
                + " Videos: " + videosCounter + " Uncategorized:" + uncategorizedCounter);
        return otherFiles;
    }

    public Path getPath() {
        return path;
    }
}

