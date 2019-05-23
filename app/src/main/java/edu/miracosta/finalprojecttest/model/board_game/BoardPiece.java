package edu.miracosta.finalprojecttest.model.board_game;

import edu.miracosta.finalprojecttest.model.enviroment.CampFire;

/**
 * This class handles as the values in a BoardPiece
 * -its x and y position on the game board
 * -its quantity of resources (firewood, animals, water)
 * -weather its an obstacle or not
 * -Keeps if it has a burning camp fire
 */

public class BoardPiece {

    private int firewood;
    private int animals;
    private int water;
    private int plants;

    private int x;
    private int y;

    private String displayText;

    private boolean isAnObstacle;
    private boolean isWarmLocation;

    private CampFire campFire;

    /**
     * Full Constructor
     * campFire is set to null because initially there will
     * be no campfires until a player makes one.
     * @param firewood
     * @param water
     * @param animals
     * @param plants
     * @param x
     * @param y
     * @param isAnObstacle
     * @param isWarmLocation
     */
    public BoardPiece(int firewood, int animals, int water, int plants, int x, int y,
                      boolean isAnObstacle, boolean isWarmLocation, String displayText) {
        this.firewood = firewood;
        this.animals = animals;
        this.water = water;
        this.plants = plants;
        this.x = x;
        this.y = y;
        this.isAnObstacle = isAnObstacle;
        this.isWarmLocation = isWarmLocation;
        this.displayText = displayText;
        this.campFire = null;
    }

    /**
     * A list of the variables and values within the BoardPiece object.
     * @return A string containing the variables and their values of this BoardPiece object
     */
    @Override
    public String toString() {
        return "BoardPiece{" +
                "firewood=" + firewood +
                ", animals=" + animals +
                ", water=" + water +
                ", plants=" + plants +
                ", x=" + x +
                ", y=" + y +
                ", isAnObstacle=" + isAnObstacle +
                ", isWarmLocation=" + isWarmLocation +
                ", campFire=" + hasCampfire() +
                ", displayText=" + displayText +
                '}';
    }

    /**
     * A null value indicated there are no active campfires in this area
     * @return
     */
    public boolean hasCampfire() {

        if (campFire == null) {
            return false;
        }
        else return true;
    }

    /**
     * If there is a campfire burning, it updates it
     */
    public void update() {

        if (campFire != null) {

            campFire.burn();

            if (campFire.getFuel() == 0) {

                campFire = null;
            }
        }
     }

    //////////Getters & Setters//////////
    /**
     * A method that returns the board piece's campfire
     * @return the campFire object within the campFire variable
     */
    public CampFire getCampFire() {
        return campFire;
    }

    /**
     * A mutator that sets the board piece's campFire
     * @param campFire a campFire object to store within the campFire variable
     */
    public void setCampFire(CampFire campFire) {
        this.campFire = campFire;
    }

    /**
     * A boolean checking whether the area the board piece is in is a warm location
     * @return boolean isWarmLocation, checking whether the area is warm or not.
     */
    public boolean isWarmLocation() {
        return isWarmLocation;
    }

    /**
     * A mutator that sets whether the board piece's location is warm
     * @param warmLocation a boolean to store into warmLocation
     */
    public void setWarmLocation(boolean warmLocation) {
        isWarmLocation = warmLocation;
    }

    /**
     * A boolean checking whether the area the board piece has an obstacle in the area
     * @return boolean isAnObstacle, true if there is an obstacle near the board piece object,
     * otherwise false
     */
    public boolean isAnObstacle() {
        return isAnObstacle;
    }

    /**
     * A mutator that sets whether the board piece's an obstacle
     * @param anObstacle an obstacle for the board piece
     */
    public void setAnObstacle(boolean anObstacle) {
        isAnObstacle = anObstacle;
    }

    /**
     * A method that returns the board piece's x position
     * @return the integer within the x variable
     */
    public int getX() {
        return x;
    }

    /**
     * A mutator that sets the board piece's x position
     * @param x an integer for the x value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * A method that returns the board piece's y position
     * @return the integer within the y variable
     */
    public int getY() {
        return y;
    }

    /**
     * A mutator that sets the board piece's y position
     * @param y an integer for the y value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * A method that returns the board piece's amount of firewood
     * @return the integer within the firewood variable
     */
    public int getFirewood() {
        return firewood;
    }

    /**
     * A mutator that sets the amount of firewood within the board piece
     * @param firewood an integer for the plants variable
     */
    public void setFirewood(int firewood) {
        this.firewood = firewood;
    }

    /**
     * A method that returns the amount of animals in the board piece
     * @return the integer within the animals variable
     */
    public int getAnimals() {
        return animals;
    }

    /**
     * A mutator that sets the amount of animals within the board piece
     * @param animals an integer for the animals variable
     */
    public void setAnimals(int animals) {
        this.animals = animals;
    }

    /**
     * A method that returns the amount of water in the board piece
     * @return the integer within the water variable
     */
    public int getWater() {
        return water;
    }

    /**
     * A mutator that sets the amount of water within the board piece
     * @param water an integer for the water variable
     */
    public void setWater(int water) {
        this.water = water;
    }

    /**
     * A method that returns the amount of plants in the board piece
     * @return the integer within the plants variable
     */
    public int getPlants() {
        return plants;
    }

    /**
     * A mutator that sets the amount of plants within the board piece
     * @param plants an integer for the plants variable
     */
    public void setPlants(int plants) {
        this.plants = plants;
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
}
