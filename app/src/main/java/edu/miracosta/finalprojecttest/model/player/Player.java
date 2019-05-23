package edu.miracosta.finalprojecttest.model.player;


import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.miracosta.finalprojecttest.model.board_game.BoardPiece;
import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.enviroment.Item;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;
import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_START;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.EAST;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.NORTH;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.WAIT;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.SOUTH;
import static edu.miracosta.finalprojecttest.view_play.PlayActivity.WEST;

/**
 * Handles all Player values and contains their Inventory:
 * - xy position in RUNNING_GAME_BOARD
 * - Condition, Hunger, Thirst, Temperature
 * - Handles if Player is inside or not
 */
public class Player implements Parcelable {

    public static final String YOU_WAITED_ALERT = "You waited and did nothing";

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


    /**
     * Default constructor, in case there are no parameters given
     */
    public Player() {
        condition = 100;
        temperature = 100;
        hunger = 100;
        thirst = 100;
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

    /**
     * Moves the player in a specific direction in the board based on the button pressed
     * @param buttonText
     * @param player
     * @param gameBoard
     * @param walkingSFX
     * @param buttonList
     * @param time
     */
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

            case WAIT:
                //pass time and do nothing
                this.displayText = YOU_WAITED_ALERT;
                time.passTime(GameTime.PASS_LRG);
                break;

        }

    }

    /**
     * If the player moves, the buttons are set to be invisible temporarily
     * @param buttonList
     */
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

    /**
     * Gets a list of what is in the player's inventory
     * @return a list of the player's inventory
     */
    public List<Item> getInventory() {

        List<Item> inventory = new ArrayList<>();

        inventory.add(new Item("firewood.png", "Firewood", firewood));
        inventory.add(new Item("food.png", "Food", food));
        inventory.add(new Item("water.png", "Water", water));
        inventory.add(new Item("plant.png", "Plants", plants));

        return inventory;
    }

    /**
     * A method that returns the total amount of items within the player's inventory
     * @return the total amount of items within the player's inventory
     */
    public int getNumInventoryItems() {
        return firewood + food + water + plants;
    }

    /**
     * A method that returns the amount of firewood in the player's inventory
     * @return the amount of firewood in the player's inventory
     */
    public int getFirewood() {
        return firewood;
    }

    /**
     * A mutator that writes a integer into the firewood variable
     * @param firewood an integer for the firewood variable
     */
    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    /**
     * A method that returns the total amount of food within the player's inventory
     * @return the integer within the food variable
     */
    public int getFood() {
        return food;
    }

    /**
     * A mutator that writes a integer into the food variable
     * @param food an integer for the food variable
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * A method that returns the total amount of water within the player's inventory
     * @return the integer within the water variable
     */
    public int getWater() {
        return water;
    }

    /**
     * A mutator that writes a water into the water variable
     * @param water an integer for the water variable
     */
    public void setWater(int water) {
        this.water = water;
    }

    /**
     * A method that returns the total amount of plants within the player's inventory
     * @return the integer within the plants variable
     */
    public int getPlants() {
        return plants;
    }

    /**
     * An mutator that writes a integer into the plants variable
     * @param plants an integer for the plants variable
     */
    public void setPlants(int plants) {
        this.plants = plants;
    }

    /**
     * A method that returns the double variable condition
     * @return the double within the condition variable
     */
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

    /**
     * A method that returns the double variable temperature
     * @return the double within the temperature variable
     */
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

    /**
     * A method that returns the double variable temperature
     * @return the double within the hunger variable
     */
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
    /**
     * A method that returns the double variable thirst
     * @return the double within the thirst variable
     */
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

    /**
     * A method that returns the player's x position
     * @return the integer within the x variable
     */
    public int getX() {
        return x;
    }

    /**
     * A method that returns the player's y position
     * @return the integer within the y variable
     */
    public int getY() {
        return y;
    }

    /**
     * A mutator that sets the player's x position
     * @param x an integer for the x value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * A mutator that sets the player's y position
     * @param y an integer for the y value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * A method that gets the display text
     * @return the string within the displayText variable
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * A mutator that sets the display text
     * @param displayText a string for the displayText variable
     */
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    ////////PARCELABLE METHODS
    /**
     * Describes the contents of the Player object
     * @return an integer
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * A way to access the campFire object as a parcelable object
     * @param dest where the parcelable information is being sent to
     * @param flags determines how the object should be written
     */
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

    /**
     * Retrieves a parcelable object and turns it into a Player object using a constructor
     * @param parcel The object used for the Player object
     */
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
        /**
         * Creates a new Player object based on the Parcelable object passed in
         * @param source the object used to create the parcelable object
         * @return the Player object made from the source
         */
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        /**
         * Creates a new Player object array
         * @param size the size of the array
         * @return the Player array made from the method
         */
        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    /**
     * A list of the variables and values within the Player object.
     * @return A string containing the variables and their values of this Player object
     */
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
}
