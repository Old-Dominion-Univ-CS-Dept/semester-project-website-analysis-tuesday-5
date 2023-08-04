package edu.odu.cs.cs350;

import edu.odu.cs.cs350.Website;

/**
* Report Writer class
*/

public interface ReportWriter {

    /**
    * Set Source Data function
    @param website
    */
    
    public void setSourceData(Website website);

    /**
    * Sets Base Name function
    @param baseFileName
    */
    
    public void setBaseName(String baseFileName);

    /**
    * write function
    */
    
    public void write();
}
