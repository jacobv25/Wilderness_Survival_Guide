package edu.miracosta.finalprojecttest.model.enviroment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TipTest {

    private Tip tip;
    @Before
    public void setUp() throws Exception {
        tip = new Tip("Camping", "Something outside", "imageName.png");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTipName() {
        assertEquals("Testing getTipName", "Camping", tip.getTipName());
    }

    @Test
    public void setTipName() {
        tip.setTipName("Rain");
        assertEquals("Testing setTipName", "Rain", tip.getTipName());
    }

    @Test
    public void getTipDescription() {
        assertEquals("Testing getTipDescription", "Something outside", tip.getTipDescription());
    }

    @Test
    public void setTipDescription() {
        tip.setTipDescription("Another thing");
        assertEquals("Testing setTipDescription", "Another thing", tip.getTipDescription());
    }

    @Test
    public void getTipImage() {
        assertEquals("Testing getTipImage", "imageName.png", tip.getTipImage());
    }

    @Test
    public void setTipImage() {
        tip.setTipImage("newImage.png");
        assertEquals("Testing setTipImage", "newImage.png", tip.getTipImage());
    }
}