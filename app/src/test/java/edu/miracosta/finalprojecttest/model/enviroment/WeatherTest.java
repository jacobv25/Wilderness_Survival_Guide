package edu.miracosta.finalprojecttest.model.enviroment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherTest {
    private GameTime gameTimeTest;
    private Weather weatherTest;
    @Before
    public void setUp() throws Exception {
        gameTimeTest = new GameTime(10, 15);
        weatherTest = new Weather(20, 30);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateTemp() {
        assertEquals("Testing calculateTemp method", -10, weatherTest.calculateTemp(gameTimeTest));
    }

    @Test
    public void testToString() {
        String expected = "Weather{" +
                "temp=" + 0 +
                ", wind=" + 20 +
                ", fog=" + 30 +
                '}';
        assertEquals("Testing toString method", expected, weatherTest.toString());
    }

    @Test
    public void getTemp() {
        assertEquals("Testing getTemp method", -10, weatherTest.calculateTemp(gameTimeTest));
    }

    @Test
    public void setTemp() {
        weatherTest.setTemp(60);
        assertEquals("Testing setTemp method", 60, weatherTest.getTemp());
    }

    @Test
    public void getWind() {
        assertEquals("Testing getWind method", 20, weatherTest.getWind());
    }

    @Test
    public void setWind() {
        weatherTest.setWind(40);
        assertEquals("Testing setWind method", 40, weatherTest.getWind());
    }

    @Test
    public void getFog() {
        assertEquals("Testing getFog method", 30, weatherTest.getFog());
    }

    @Test
    public void setFog() {
        weatherTest.setFog(100);
        assertEquals("Testing getFog method", 100, weatherTest.getFog());
    }
}