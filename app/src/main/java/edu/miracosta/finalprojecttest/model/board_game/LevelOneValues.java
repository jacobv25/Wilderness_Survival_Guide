package edu.miracosta.finalprojecttest.model.board_game;

/**
 * LevelOneValues.java: Pieces used to set up the board for the game
 * @author Jacob Valenzuela and Gabriel Bactol
 * @since 5/22/19
 */
public class LevelOneValues {

    public static BoardPiece STN_FRST = new BoardPiece(1, 0, 0, 0, 0, 0,
            false, false, "Deep foreboding forest.");
    public static BoardPiece __WELL__ = new BoardPiece(0, 0, 10, 0, 0, 0,
            false, false, "A deep well containing water.");
    public static BoardPiece HRB_TREE = new BoardPiece(0, 0, 0, 1, 0, 0,
            false, false, "A clearing with a .");
    public static BoardPiece __ROAD__ = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "A road going in the north south direction.");
    public static BoardPiece CLEARING = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "An open clearing in front abin.");
    public static BoardPiece SCRT_PTH = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "A small trail leads away from the road and to a small cave.");
    public static BoardPiece _TRAIL__ = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "A snowy trail with tall white trees on both sides.");
    public static BoardPiece ROAD_3_3 = new BoardPiece(0, 0, 0, 0, 0, 0,
            false, false, "A road going north-south.\nA car crash lays before you");
    public static BoardPiece CABN_5_2 = new BoardPiece(10, 0, 0, 0, 5, 2,
            false, true,"You enter a dark wood cabin.\nYou feel safe and warm.");
    public static BoardPiece FNSH_1_4 = new BoardPiece(0, 0, 0, 0, 1, 6,
            false, false, "A cave that cuts through the mountains to a small town.");




    public static final BoardPiece MOUNTAIN = new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false, "Impassable mountains.");
    public static final BoardPiece BLK_FRST= new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false, "You try to move through\nthe thick brush. You think it\n best to stay on the trail.");
    public static final BoardPiece _CLIFF__ = new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false,"The roadside guardrail prevent you\nfrom going any farther\nand a falling off a 100m sheer cliff!");
    public static final BoardPiece BLCKD_RD = new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false, "The tunnel that leads north to the town is\nfucking blocked. Shit.");
    public static final BoardPiece _TUNNEL_ = new BoardPiece(0, 0, 0, 0, 0, 0,
            true, false, "The road leads into a tunnel.\nWith the lights knocked out\nonly darkness lies ahead\nThe Darkness beckons you\nYou dare not go farther.");

}
