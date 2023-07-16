package edu.odu.cs.cs350;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportWriter {

    // Default constructor (not needed in most cases)
    public ReportWriter() {
    }

    /**
     * Generates the name for the output files.
     *
     * @param extension The file extension (json, txt, xlsx)
     * @return The generated file name as a string
     */
    public static String nameFile(String extension) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String formattedDateTime = now.format(formatter);

        return formattedDateTime + "-summary." + extension;
    }
}
