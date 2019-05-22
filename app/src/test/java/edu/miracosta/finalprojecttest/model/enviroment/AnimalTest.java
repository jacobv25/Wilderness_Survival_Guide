package edu.miracosta.finalprojecttest.model.enviroment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animalTest;
    @Before
    public void setUp() throws Exception {
        animalTest = new Animal("Bear", "A Description", "imageName.png");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAnimalName() {
        assertEquals("Testing getAnimalName method", "Bear", animalTest.getAnimalName());
    }

    @Test
    public void setAnimalName() {
        animalTest.setAnimalName("Cat");
        assertEquals("Testing setAnimalName method", "Cat", animalTest.getAnimalName());
    }

    @Test
    public void getAnimalDescription() {
        assertEquals("Testing getAnimalDescription method", "A Description", animalTest.getAnimalDescription());
    }

    @Test
    public void setAnimalDescription() {
        animalTest.setAnimalDescription("A New Description");
        assertEquals("Testing setAnimalDescription method", "A New Description", animalTest.getAnimalDescription());
    }

    @Test
    public void getAnimalImage() {
        assertEquals("Testing getAnimalImage method", "imageName.png", animalTest.getAnimalImage());

    }

    @Test
    public void setAnimalImage() {
        animalTest.setAnimalImage("newImage.png");
        assertEquals("Testing setAnimalImage method", "newImage.png", animalTest.getAnimalImage());
    }
}