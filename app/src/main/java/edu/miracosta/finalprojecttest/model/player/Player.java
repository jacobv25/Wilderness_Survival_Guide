package edu.miracosta.finalprojecttest.model.player;


import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.miracosta.finalprojecttest.R;
import edu.miracosta.finalprojecttest.model.board_game.BoardGame;
import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.model.board_game.BoardValues;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.enviroment.Item;
import edu.miracosta.finalprojecttest.view_play.PlayActivity;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_START;
import static edu.miracosta.finalprojecttest.model.player.Action.MTN_BLOCK_ALERT;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.EAST;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.NORTH;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.PASS_TIME;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.SOUTH;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.WEST;

/**
 * Handles all Player values and contains their Inventory:
 * - xy position in RUNNING_GAME_BOARD
 * - Condition, Hunger, Thirst, Temperature
 * - Handles if Player is inside or not
 */
public class Player implements Parcelable {


    public static final int MAX_VALUE = 100;
    public static final int MIN_VALUE = 0;


    private double condition;
    private double temperature;
    private double hunger;
    private double thirst;

    private int x;
    private int y;

    private String displayText;

    //private Inventory inventory;

    private int firewood;
    private int food;
    private int water;
    private int plants;



    public Player() {
        condition = MAX_VALUE;
        temperature = MAX_VALUE;
        hunger = MAX_VALUE;
        thirst = MAX_VALUE;
        x = RUNNING_GAME_START.getX();
        y = RUNNING_GAME_START.getY();
        //inventory = new Inventory();
        firewood = 0;
        food = 0;
        water = 0;
        plants = 0;

    }

    /**
     * If player's xy position is equal to the xy pos of the Cabin,
     * then set isPlayerInside variable to true
     * @return
     */
    public boolean isPlayerInside(BoardPiece[][] gameBoard) {
        if (gameBoard[y][x].isWarmLocation()) {
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Player{" +
                "condition=" + condition +
                ", temperature=" + temperature +
                ", hunger=" + hunger +
                ", thirst=" + thirst +
                ", x=" + x +
                ", y=" + y +
                ", isInside=" + isPlayerInside(RUNNING_GAME_BOARD) +
                '}';
    }

    /**
     * toString for the Player's inventory
     * @return
     */
    public String inventoryToString() {

        return "Inventory{" +
                "firewood=" +  firewood +
                ", food=" + food +
                ", water bottle=" + water;
    }

    public void movePlayerBoardPiece(String buttonText, Player player, BoardPiece[][] gameBoard,
                                     MediaPlayer walkingSFX, List<Button> buttonList, GameTime time) {

        int x = player.getX();
        int y = player.getY();
        switch (buttonText)
        {
            case EAST:
                if (!gameBoard[y][x + 1].isAnObstacle()) {

                    player.setX(x + 1);
                    walkingSFX.start();
                    setButtonsInvisibleAfterMove(buttonList);
                    time.passTime(GameTime.PASS_LRG);
                }
                this.displayText = gameBoard[y][x + 1].getDisplayText();
                break;

            case WEST:
                if (!gameBoard[y][x - 1].isAnObstacle()) {

                    player.setX(x - 1);
                    walkingSFX.start();
                    setButtonsInvisibleAfterMove(buttonList);
                    time.passTime(GameTime.PASS_LRG);
                }
                this.displayText = gameBoard[y][x - 1].getDisplayText();
                break;

            case NORTH:
                if (!gameBoard[y - 1][x].isAnObstacle()) {

                    player.setY(y - 1);
                    walkingSFX.start();
                    setButtonsInvisibleAfterMove(buttonList);
                    time.passTime(GameTime.PASS_LRG);
                }
                this.displayText = gameBoard[y-1][x].getDisplayText();
                break;

            case SOUTH:
                if (!gameBoard[y + 1][x].isAnObstacle()) {

                    player.setY(y + 1);
                    walkingSFX.start();
                    setButtonsInvisibleAfterMove(buttonList);
                    time.passTime(GameTime.PASS_LRG);
                }
                this.displayText = gameBoard[y + 1][x].getDisplayText();
                break;

            case PASS_TIME:
                //pass time and do nothing
                this.displayText = "You waited where you are and passed time.";
                time.passTime(GameTime.PASS_LRG);
                break;

        }

    }

    private void setButtonsInvisibleAfterMove(final List<Button> buttonList) {

        //change all buttons to INVISIBLE
        for (int i = 0; i < buttonList.size(); i++ ) {
            buttonList.get(i).setVisibility(View.INVISIBLE);
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //change all buttons to VISIBLE
                for (int i = 0; i < buttonList.size(); i++ ) {
                    buttonList.get(i).setVisibility(View.VISIBLE);
                }
            }
        }, 2500);
    }

    public List<Item> getInventory() {

        List<Item> inventory = new ArrayList<>();

        inventory.add(new Item("Insert Firewood image", "Firewood", firewood));
        inventory.add(new Item("Insert Food image", "Food", food));
        inventory.add(new Item("Insert Water image", "Water", water));
        inventory.add(new Item("Insert Plant image", "Plants", plants));

        return inventory;
    }

    public int getNumInventoryItems () {
        return firewood + food + water + plants;
    }

    public int getFirewood() {
        return firewood;
    }

    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getPlants() {
        return plants;
    }

    public void setPlants(int plants) {
        this.plants = plants;
    }

    public double getCondition() {
        return condition;
    }

    /**
     * Checks that Condition value is between 0 and 100
     * @param condition
     */
    public void setCondition(double condition) {

        if (condition < 0) {

            this.condition = 0;
        }
        else if (condition > 100) {

            this.condition = 100;
        }
        else this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    /**
     * Checks that the temperature remains between 0 and 100
     * @param temperature
     */
    public void setTemperature(double temperature) {

        if (temperature < 0) {

            this.temperature = 0;
        }
        else if (temperature > 100) {

            this.temperature = 100;
        }
        else this.temperature = temperature;
    }

    public double getHunger() {
        return hunger;
    }

    /**
     * Makes sure the hunger value stays between 0 and 100
     * @param hunger
     */
    public void setHunger(double hunger) {

        if (hunger < 0) {

            this.hunger = 0;
        }
        else if (hunger > 100) {

            this.hunger = 100;
        }
        else this.hunger = hunger;

    }

    public double getThirst() {
        return thirst;
    }

    /**
     * Makes sure the thirst value stays between 0 and 100
     * @param thirst
     */
    public void setThirst(double thirst) {

        if (thirst < 0) {

            this.thirst = 0;
        }
        else if (thirst > 100) {

            this.thirst = 100;
        }
        else this.thirst = thirst;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    ////////PARCELABLE METHODS
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(condition);
        dest.writeDouble(temperature);
        dest.writeDouble(hunger);
        dest.writeDouble(thirst);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeString(displayText);

        dest.writeInt(firewood);
        dest.writeInt(food);
        dest.writeInt(water);
        dest.writeInt(plants);
    }

    private Player(Parcel parcel) {
        condition = parcel.readDouble();
        temperature = parcel.readDouble();
        hunger = parcel.readDouble();
        thirst = parcel.readDouble();
        x = parcel.readInt();
        y = parcel.readInt();
        displayText = parcel.readString();

        firewood = parcel.readInt();
        food = parcel.readInt();
        water = parcel.readInt();
        plants = parcel.readInt();
    }

    public static final Parcelable.Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
