package edu.miracosta.finalprojecttest.model.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegenerationTest {

    private static Player player;
    public static final double DELTA = 1e-15;

    @Before
    public void setUp() {

        player = new Player();
        player.setCondition(50);
        player.setTemperature(50);
        player.setHunger(50);
        player.setThirst(50);
    }
    @Test
    public void regeneratePlayer() {

        Regeneration.regeneratePlayer(player);
        assertEquals(52, player.getCondition(),DELTA);
        assertEquals(60, player.getTemperature(),DELTA);
        assertEquals(50, player.getHunger(), DELTA);
        assertEquals(50, player.getThirst(), DELTA);
    }

    @Test
    public void regenThirst() {

        Regeneration.regenThirst(player);
        assertEquals(75, player.getThirst(), DELTA);

    }

    @Test
    public void regenHunger() {

        Regeneration.regenHunger(player);
        assertEquals(60, player.getHunger(), DELTA);
    }

    @Test
    public void regenFromFire() {

        Regeneration.regenFromFire(player);
        assertEquals(60, player.getTemperature(), DELTA);
    }
}