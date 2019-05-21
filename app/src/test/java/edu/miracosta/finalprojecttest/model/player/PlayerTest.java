package edu.miracosta.finalprojecttest.model.player;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.miracosta.finalprojecttest.model.board_game.BoardGame;
import edu.miracosta.finalprojecttest.model.board_game.TestValues;
import edu.miracosta.finalprojecttest.model.enviroment.Item;

import static org.junit.Assert.*;

public class PlayerTest {

    private static Player player;
    private static final double DELTA = 1e-15;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {


    }

    @Before
    public void setUp() throws Exception {

        player = new Player();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPlayerInside() {
        player.setX(TestValues.TST_STRT.getX());
        player.setY(TestValues.TST_STRT.getY());
        assertEquals(true, player.isPlayerInside(BoardGame.GAME_BOARD_PIECES_TEST));
    }

    @Test
    public void movePlayerBoardPiece() {

        //Seperate JUnit class for movement
    }

    @Test
    public void getInventory() {
        List<Item> testInventory = new ArrayList<>();

        testInventory.add(new Item("Insert Firewood image", "Firewood", 1));
        testInventory.add(new Item("Insert Food image", "Food", 2));
        testInventory.add(new Item("Insert Water image", "Water", 3));
        testInventory.add(new Item("Insert Plant image", "Plants", 4));

        player.setFirewood(1);
        player.setFirewood(2);
        player.setFirewood(3);
        player.setFirewood(4);

        assertEquals(testInventory, player.getInventory());
    }

    @Test
    public void getNumInventoryItems() {
        player.setFirewood(3);
        player.setFood(6);
        assertEquals(9, player.getNumInventoryItems());
    }

    @Test
    public void getFirewood() {

        player.setFirewood(6);
        assertEquals(6, player.getFirewood() );

    }

    @Test
    public void setFirewood() {

        player.setFirewood(5);
        assertEquals(5, player.getFirewood());
    }

    @Test
    public void getFood() {
        player.setFood(9);
        assertEquals(9, player.getFood());
    }

    @Test
    public void setFood() {
        player.setFood(10);
        assertEquals(10, player.getFood());
    }

    @Test
    public void getWater() {
        player.setWater(27);
        assertEquals(27, player.getWater());

    }

    @Test
    public void setWater() {
        player.setWater(78);
        assertEquals(78, player.getWater());
    }

    @Test
    public void getPlants() {
        player.setPlants(54);
        assertEquals(54, player.getPlants());
    }

    @Test
    public void setPlants() {
        player.setPlants(98);
        assertEquals(98, player.getPlants());
    }

    @Test
    public void getCondition() {

        player.setCondition(85.4);
        assertEquals(85.4, player.getCondition(), DELTA);
    }

    @Test
    public void setCondition() {

        player.setCondition(44.2);
        assertEquals(44.2, player.getCondition(), DELTA);
    }

    @Test
    public void getTemperature() {

        player.setTemperature(12.2);
        assertEquals(12.2, player.getTemperature(), DELTA);
    }

    @Test
    public void setTemperature() {

        player.setTemperature(45.5);
        assertEquals(45.5, player.getTemperature(), DELTA);
    }

    @Test
    public void getHunger() {

        player.setTemperature(22.2);
        assertEquals(22.2, player.getHunger(),DELTA);
    }

    @Test
    public void setHunger() {

        player.setHunger(11.8);
        assertEquals(11.8, player.getHunger(), DELTA);
    }

    @Test
    public void getThirst() {

        player.setThirst(55.88);
        assertEquals(55.88, player.getThirst(), DELTA);
    }

    @Test
    public void setThirst() {

        player.setThirst(11.88);
        assertEquals(11.88, player.getThirst(), DELTA);
    }

    @Test
    public void getX() {
        player.setX(5);
        assertEquals(5, player.getX());
    }

    @Test
    public void getY() {
        player.setY(5);
        assertEquals(5, player.getY());
    }

    @Test
    public void setX() {
        player.setX(9);
        assertEquals(9, player.getX());
    }

    @Test
    public void setY() {
        player.setX(20);
        assertEquals(20, player.getX());
    }

    @Test
    public void getDisplayText() {
        player.setDisplayText("Testing Display Text");
        assertEquals("Testing Display Text", player.getDisplayText());
    }

    @Test
    public void setDisplayText() {

        player.setDisplayText("Testing Display Text Part2");
        assertEquals("Testing Display Text Part2", player.getDisplayText());
    }


    @Test
    public void testToString() {
        Player testPlayer = new Player();
        testPlayer.setY(5);
        testPlayer.setFood(33);
        player.setY(5);
        player.setFood(33);
        assertEquals(testPlayer.toString(), player.toString());
    }

    @Test
    public void inventoryToString() {

        Player testPlayer = new Player();
        testPlayer.setPlants(5);
        testPlayer.setFirewood(33);
        player.setPlants(5);
        player.setFirewood(33);
        assertEquals(testPlayer.inventoryToString(), player.inventoryToString());
    }
}