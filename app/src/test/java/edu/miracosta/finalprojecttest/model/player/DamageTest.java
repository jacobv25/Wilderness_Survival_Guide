package edu.miracosta.finalprojecttest.model.player;

import org.junit.Test;

import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.enviroment.Weather;

import static org.junit.Assert.*;

public class DamageTest {

    public static final double DELTA = 1e-15;
    @Test
    public void damagePlayerSmall() {
        Player player = new Player();
        GameTime gameTime = new GameTime();
        Weather weather = new Weather();
        weather.calculateTemp(gameTime);
        Damage.damagePlayerSmall(player, weather, gameTime);
        assertEquals(100, player.getCondition(), DELTA);
        assertEquals(100, player.getTemperature(), DELTA);
        assertEquals(98, player.getHunger(), DELTA);
        assertEquals(99, player.getThirst(), DELTA);
    }

    @Test
    public void damagePlayerLarge() {

        Player player = new Player();
        GameTime gameTime = new GameTime();
        Weather weather = new Weather();
        weather.calculateTemp(gameTime);
        Damage.damagePlayerLarge(player, weather, gameTime);
        assertEquals(100, player.getCondition(), DELTA);
        assertEquals(100, player.getTemperature(), DELTA);
        assertEquals(88, player.getHunger(), DELTA);
        assertEquals(97, player.getThirst(), DELTA);
    }
}