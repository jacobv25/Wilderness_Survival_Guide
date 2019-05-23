package edu.miracosta.finalprojecttest.model.enviroment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlantTest {

    private Plant plantTest;
    @Before
    public void setUp() throws Exception {
        plantTest = new Plant("Dandelion", "A flower", "imageFile.png");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPlantName() {
        assertEquals("Testing getPlantName method", "Dandelion", plantTest.getPlantName());
    }

    @Test
    public void setPlantName() {
        plantTest.setPlantName("Cattail");
        assertEquals("Testing setPlantName method", "Cattail", plantTest.getPlantName());
    }

    @Test
    public void getPlantDetails() {
        assertEquals("Testing getPlantDetails method", "A flower", plantTest.getPlantDetails());
    }

    @Test
    public void setPlantDetails() {
        plantTest.setPlantDetails("Edible");
        assertEquals("Testing setPlantDetails method", "Edible", plantTest.getPlantDetails());
    }

    @Test
    public void getPlantImage() {
        assertEquals("Testing getPlantImage method", "imageFile.png", plantTest.getPlantImage());
    }

    @Test
    public void setPlantImage() {
        plantTest.setPlantImage("aFile.png");
        assertEquals("Testing setPlantImage method", "aFile.png", plantTest.getPlantImage());
    }
}