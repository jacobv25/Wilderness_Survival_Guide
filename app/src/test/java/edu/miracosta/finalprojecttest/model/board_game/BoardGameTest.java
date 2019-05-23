package edu.miracosta.finalprojecttest.model.board_game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.BLCKD_RD;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.CABN_5_2;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.FNSH_1_4;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.MOUNTAIN;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.SCRT_PTH;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues._CLIFF__;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues._TRAIL__;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues._TUNNEL_;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.__ROAD__;
import static edu.miracosta.finalprojecttest.model.board_game.LevelOneValues.__WELL__;
import static org.junit.Assert.*;

public class BoardGameTest {

    private BoardGame boardGameTest;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Note: Because of the way that the method is written, there is not a way to test the method
     */

    @Test
    public void update() {
        boardGameTest.update();
        assertEquals("Testing the update method", boardGameTest);
    }

}