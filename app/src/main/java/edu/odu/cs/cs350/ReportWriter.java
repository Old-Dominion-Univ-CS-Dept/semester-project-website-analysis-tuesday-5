package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Website;

public interface ReportWriter {
    public void setSourceData(Website website);
    public void setBaseName(String baseFileName);

    public void write();
}
