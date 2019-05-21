package edu.miracosta.finalprojecttest.model.board_game;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TEST_1_1;
import static edu.miracosta.finalprojecttest.model.board_game.BoardValues.TST_STRT;
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

/**
 * Handles the different 2d arrays that act as game boards
 */
public class BoardGame {

    /**
     * Iterate through the double array and update
     * the game board pieces that are NOT mountains
     */
    public static void update() {

        for (int i = 0; i < RUNNING_GAME_BOARD.length; i++) {
            for (int j = 0; j < RUNNING_GAME_BOARD[i].length; j++) {
                if (RUNNING_GAME_BOARD[i][j] != MOUNTAIN) {
                    RUNNING_GAME_BOARD[i][j].update();
                }
            }
        }
    }
    /**
     * Level 1 v.0.5 design
     *
     * Used as a tester for the level 1
     */
    //TODO: Check player.movePlayer method and fix displayText bug when running off a cliff
    public static final BoardPiece[][] LEVEL_1 = {
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, BLCKD_RD, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, _CLIFF__, __ROAD__, _TRAIL__, CABN_5_2, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, _CLIFF__, __ROAD__, MOUNTAIN, __WELL__, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, FNSH_1_4, SCRT_PTH, __ROAD__, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, _TUNNEL_, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
    };
     /**
     * v.0.4 design
     *
     * Used as a tester for the final
     */
//    public static final BoardPiece[][] GAME_BOARD_PIECES = {
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, STN_FRST, STN_FRST, STN_FRST, STN_FRST, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, STN_FRST, ROAD_2_2, TRAL_3_2, TRAL_4_2, TRAL_5_2, CABN_5_2, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, STN_FRST, ROAD_2_3, MOUNTAIN, STN_FRST, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, STN_FRST, ROAD_2_4, MOUNTAIN, FRST_4_4, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, STN_FRST, ROAD_2_5, MOUNTAIN, STN_FRST, STN_FRST, STN_FRST, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, FNSH_1_4, ROAD_2_6, MOUNTAIN, STN_FRST, WELL_5_6, STN_FRST, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
//            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
//    };
    /**
     * v.0.3 design
     *
     * Used as a tester
     */
    public static final BoardPiece[][] GAME_BOARD_PIECES_TEST = {
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, TEST_1_1, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, TST_STRT, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN},
            {MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN, MOUNTAIN}
    };
}
