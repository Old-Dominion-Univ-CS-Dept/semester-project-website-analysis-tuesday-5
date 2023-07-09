package edu.odu.cs.cs350;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class AnchorTest {

    @Test void Anchor() {
        Anchor anchor = new Anchor();
        assertEquals(0, anchor.sizeOfFile);
        
    }
    
}