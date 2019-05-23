package edu.miracosta.finalprojecttest.model.enviroment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    private Item itemTest;
    @Before
    public void setUp() throws Exception {
        itemTest = new Item("imageFile.png", "water", 10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getImageName() {
        assertEquals("Testing getImageName method", "imageFile.png", itemTest.getImageName());
    }

    @Test
    public void setImageName() {
        itemTest.setImageName("aFile.png");
        assertEquals("Testing getImageName method", "aFile.png", itemTest.getImageName());
    }

    @Test
    public void getName() {
        assertEquals("Testing getName method", "water", itemTest.getName());
    }

    @Test
    public void setName() {
        itemTest.setName("wood");
        assertEquals("Testing setName method", "wood", itemTest.getName());
    }

    @Test
    public void getCount() {
        assertEquals("Testing getCount method", 10, itemTest.getCount());
    }

    @Test
    public void setCount() {
        itemTest.setCount(20);
        assertEquals("Testing getCount method", 20, itemTest.getCount());
    }
}