package com.madlibrary;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class MADLibraryTest {

    @Test
    public void testTotalProgrammesCount() {
        assertEquals("Total programmes must be 10", 10, MADLibrary.getTotalProgrammes());
        assertEquals("getAllProgrammes must return 10 items", 10, MADLibrary.getAllProgrammes().size());
    }

    @Test
    public void testProgrammeMetadata() {
        ProgrammeDetails p1 = MADLibrary.getProgramme(1);
        assertNotNull(p1);
        assertEquals("Text Color Changer", p1.getTitle());
        assertEquals("com.example.myapplication1", p1.getPackageName());
        assertTrue(p1.getFileNames().contains("MainActivity.java"));
        assertTrue(p1.getFileNames().contains("activity_main.xml"));
        assertTrue(p1.getFileNames().contains("AndroidManifest.xml"));

        ProgrammeDetails p6 = MADLibrary.getProgramme(6);
        assertNotNull(p6);
        assertEquals("Explicit & Implicit Intent", p6.getTitle());
        assertTrue(p6.getFileNames().contains("new6.java"));
        assertTrue(p6.getFileNames().contains("new6.xml"));
        assertTrue(p6.getFileNames().contains("res_new6"));

        ProgrammeDetails p8 = MADLibrary.getProgramme(8);
        assertNotNull(p8);
        assertEquals("Options Menu Demo", p8.getTitle());
        assertTrue(p8.getFileNames().contains("menu_main.xml"));
        assertTrue(p8.getFileNames().contains("menu_ma.xml"));
        assertTrue(p8.getFileNames().contains("menu_mai.xml"));
        assertTrue(p8.getFileNames().contains("new6.java"));

        ProgrammeDetails p10 = MADLibrary.getProgramme(10);
        assertNotNull(p10);
        assertEquals("Number Guessing Game", p10.getTitle());
    }

    @Test
    public void testInvalidProgrammeNumber() {
        assertNull(MADLibrary.getProgramme(0));
        assertNull(MADLibrary.getProgramme(11));
        assertTrue(MADLibrary.getFileNames(99).isEmpty());
    }
}
