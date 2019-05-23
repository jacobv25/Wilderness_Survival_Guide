package edu.miracosta.finalprojecttest.model.enviroment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CampFireTest {

    private GameTime gameTimeTest;
    private CampFire campFireTest;
    @Before
    public void setUp() throws Exception {
        gameTimeTest= new GameTime(10, 15);
        campFireTest = new CampFire(gameTimeTest);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void burn() {
        campFireTest.burn();
        assertEquals("Testing burn method", 9, campFireTest.getFuel());
    }

    @Test
    public void stoke() {
        campFireTest.stoke();
        assertEquals("Testing stoke method", 15, campFireTest.getFuel());
    }

    @Test
    public void testToString() {
        String expected =  "CampFire{" +
                "fuel=" + 10 +
                '}';
        assertEquals("Testing toString method", expected, campFireTest.toString());
    }

    @Test
    public void getFuel() {
        assertEquals("Testing getFuel method", 10, campFireTest.getFuel());
    }

    @Test
    public void setFuel() {
        campFireTest.setFuel(20);
        assertEquals("Testing setFuel method", 20, campFireTest.getFuel());
    }
}