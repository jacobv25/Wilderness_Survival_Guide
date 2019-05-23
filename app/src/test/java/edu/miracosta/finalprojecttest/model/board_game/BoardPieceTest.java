package edu.miracosta.finalprojecttest.model.board_game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.miracosta.finalprojecttest.model.enviroment.CampFire;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;

import static org.junit.Assert.*;

public class BoardPieceTest {
    private BoardPiece boardPieceTest;
    @Before
    public void setUp() throws Exception {
        boardPieceTest = new BoardPiece(10,20,30,40,7,11,false,true, "Text");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        String expected = "BoardPiece{" +
                "firewood=" + 10 +
                ", animals=" + 20 +
                ", water=" + 30 +
                ", plants=" + 40 +
                ", x=" + 7 +
                ", y=" + 11 +
                ", isAnObstacle=" + false +
                ", isWarmLocation=" + true +
                ", campFire=" + false +
                ", displayText=" + "Text" +
                '}';
        assertEquals("Testing toString", expected, boardPieceTest.toString());
    }

    @Test
    public void hasCampfire() {
        assertEquals("Testing hasCampFire method", false, boardPieceTest.hasCampfire());

    }

    @Test
    public void update() {
        CampFire fire = new CampFire(new GameTime(10,15));
        fire.burn();
        boardPieceTest.setCampFire(fire);
        boardPieceTest.update();
        assertEquals("Testing update method,", fire, boardPieceTest.getCampFire());
    }

    @Test
    public void getCampFire() {
        assertEquals("Testing getCampFire method", null, boardPieceTest.getCampFire());
    }

    @Test
    public void setCampFire() {
        CampFire fire = new CampFire(new GameTime(10,15));
        boardPieceTest.setCampFire(fire);
        assertEquals("Testing setCampFire method", fire, boardPieceTest.getCampFire());
    }

    @Test
    public void isWarmLocation() {
        assertEquals("Testing isWarmLocation method", true, boardPieceTest.isWarmLocation());
    }

    @Test
    public void setWarmLocation() {
        boardPieceTest.setWarmLocation(false);
        assertEquals("Testing setWarmLocation method", false, boardPieceTest.isWarmLocation());
    }

    @Test
    public void isAnObstacle() {
        assertEquals("Testing isAnObstacle method", false, boardPieceTest.isAnObstacle());
    }

    @Test
    public void setAnObstacle() {
        boardPieceTest.setAnObstacle(true);
        assertEquals("Testing setAnObstacle method", true, boardPieceTest.isAnObstacle());
    }

    @Test
    public void getX() {
        assertEquals("Testing getX method", 7, boardPieceTest.getX());
    }

    @Test
    public void setX() {
        boardPieceTest.setX(17);
        assertEquals("Testing setX method", 17, boardPieceTest.getX());
    }

    @Test
    public void getY() {
        assertEquals("Testing getY method", 11, boardPieceTest.getY());
    }

    @Test
    public void setY() {
        boardPieceTest.setY(35);
        assertEquals("Testing setY method", 35, boardPieceTest.getY());
    }

    @Test
    public void getFirewood() {
        assertEquals("Testing getFirewood method", 10, boardPieceTest.getFirewood());
    }

    @Test
    public void setFirewood() {
        boardPieceTest.setFirewood(15);
        assertEquals("Testing setFirewood method", 15, boardPieceTest.getFirewood());
    }

    @Test
    public void getAnimals() {
        assertEquals("Testing getAnimals method", 20, boardPieceTest.getAnimals());
    }

    @Test
    public void setAnimals() {
        boardPieceTest.setAnimals(35);
        assertEquals("Testing setAnimals method", 35, boardPieceTest.getAnimals());
    }

    @Test
    public void getWater() {
        assertEquals("Testing getWater method", 30, boardPieceTest.getWater());
    }

    @Test
    public void setWater() {
        boardPieceTest.setWater(90);
        assertEquals("Testing setWater method", 90, boardPieceTest.getWater());
    }

    @Test
    public void getPlants() {
        assertEquals("Testing getPlants", 40, boardPieceTest.getPlants());
    }

    @Test
    public void setPlants() {
        boardPieceTest.setPlants(80);
        assertEquals("Testing setPlants", 80, boardPieceTest.getPlants());
    }

    @Test
    public void getDisplayText() {
        assertEquals("Testing getDisplayText", "Text", boardPieceTest.getDisplayText());
    }

    @Test
    public void setDisplayText() {
        boardPieceTest.setDisplayText("newText");
        assertEquals("Testing setDisplayText", "newText", boardPieceTest.getDisplayText());
    }
}