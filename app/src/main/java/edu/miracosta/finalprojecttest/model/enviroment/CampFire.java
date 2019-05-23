package edu.miracosta.finalprojecttest.model.enviroment;

/**
 * This class will handle all the functions and calculations for a CampFire
 *
 * Right now, a new CampFire will burn indefinitely after just one single piece of wood.
 * Ideally, the fire will fade and will need to be restoked.
 *
 * In a super ideal world, the strength of warmth the fire gives will be related to the
 * CampFire's fuel level. But that may be a bit too much work to work on when there's still a ton of
 * other stuff to finish.
 */
public class CampFire {


    private int fuel;
    private boolean isEmpty;

    /**
     * Creates a new CampFire that will warm the player
     * @param gameTime
     */
    public CampFire(GameTime gameTime) {

        fuel = 10;      // 1 firewood cost = 10 fuel
        isEmpty = false;
    }

    /**
     * A method that decreases the fuel by 1
     */
    public void burn() {

        fuel = fuel - 1;
    }

    /**
     * A method that increases the fuel by 5
     */
    public void stoke() {

        fuel = fuel + 5;
    }

    /**
     * A list of the variables and values within the CampFire object.
     * @return A string containing the variables and their values of this campFire object
     */
    @Override
    public String toString() {
        return "CampFire{" +
                "fuel=" + fuel +
                '}';
    }

    /////////Setters & Getters/////////
    /**
     * A method that returns the amount of fuel within the campFire object
     * @return the integer within the fuel variable
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * A mutator that sets the amount of fuel within the campFire object
     * @param fuel The amount of fuel, or integer, to store into the fuel integer
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

}
