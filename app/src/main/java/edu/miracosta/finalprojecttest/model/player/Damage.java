package edu.miracosta.finalprojecttest.model.player;

import android.util.Log;

import edu.miracosta.finalprojecttest.model.enviroment.GameTime;
import edu.miracosta.finalprojecttest.model.enviroment.Weather;

import static edu.miracosta.finalprojecttest.MainActivity.RUNNING_GAME_BOARD;

/**
 * Handles the calculations that determine how much damage the character takes.
 * Depends on time of day and current weather conditions.
 */
public class Damage {

    public static final double FREEZING_POINT = 32; //32 deg Fahrenheit

    public static final double CONDITION_DAMAGE_FREEZING_SMALL = 1.7;
    public static final double CONDITION_DAMAGE_FREEZING_LARGE = 10;
    public static final double CONDITION_DAMAGE_HUNGER_SMALL = .1;
    public static final double CONDITION_DAMAGE_HUNGER_LARGE = .5;
    public static final double CONDITION_DAMAGE_THIRST_SMALL = .8;
    public static final double CONDITION_DAMAGE_THIRST_LARGE = 5;
    public static final double THIRST_DAMAGE_SMALL = 1;
    public static final double THIRST_DAMAGE_LARGE = 3;
    public static final double HUNGER_DAMAGE_WAIT = 1;
    public static final double HUNGER_DAMAGE_SMALL = 2;
    public static final double HUNGER_DAMAGE_LARGE = 12;

    /**
     *  If the Player is NOT inside,
     *  then calculate freezing damage.
     *
     *  Calculate the Player's hunger, thirst and condition damage
     *
     *  Calculate the damge based on a small amount of time passing
     *
     * @param player
     * @param weather
     * @param gameTime
     */
    public static void damagePlayerSmall(Player player, Weather weather, GameTime gameTime) {

        weather.calculateTemp(gameTime);
        if (!player.isPlayerInside(RUNNING_GAME_BOARD)) {
            calcTempDamageSmall(player, weather, gameTime);
        }

        calcHungerDamageSmall(player);

        calcThirstDamageSmall(player);

        calcConditionDamageSmall(player);
    }
    /**
     *  Checks the current weather and determines the damage to the Player's temperature.
     *  The lower the temperature, the more damage done.
     *  Calculates based off a small amount of time passing.
     * @param player
     * @param weather
     * @param gameTime
     */
    private static void calcTempDamageSmall(Player player, Weather weather, GameTime gameTime) {

        double freezingDamage;
        double currentPlayerTemp = player.getTemperature();

        if (weather.calculateTemp(gameTime) < FREEZING_POINT) {

            freezingDamage = FREEZING_POINT - weather.calculateTemp(gameTime);
            freezingDamage = freezingDamage / 6.0;
            player.setTemperature(currentPlayerTemp - freezingDamage);
        }
    }
    /**
     * Sets the Player's thirst to what it was, minus THIRST_DAMAGE_SMALL
     *
     * @param player
     */
    private static void calcThirstDamageSmall(Player player) {

        double currentPlayerThirst = player.getThirst();

        player.setThirst(currentPlayerThirst - THIRST_DAMAGE_SMALL);
    }
    /**
     * Sets the Player's hunger to what it originally was, minus HUNGER_DAMAGE_SMALL
     *
     * @param player
     */
    private static void calcHungerDamageSmall(Player player) {

        double currentPlayerHunger = player.getHunger();

        player.setHunger(currentPlayerHunger - HUNGER_DAMAGE_SMALL);
    }

    /**
     * If the Player's hunger, thirst or warmth reach zero, the Player's condition will begin to drop
     * @param player
     */
    private static void calcConditionDamageSmall(Player player) {

        if (player.getTemperature() == 0) {

            player.setCondition(player.getCondition() - CONDITION_DAMAGE_FREEZING_SMALL);
        }
        else if (player.getThirst() == 0) {

            player.setCondition(player.getCondition() - CONDITION_DAMAGE_THIRST_SMALL);
        }
        else if (player.getHunger() == 0) {

            player.setCondition(player.getCondition() - CONDITION_DAMAGE_HUNGER_SMALL);
        }
    }
    /**
     *  If the Player is NOT inside,
     *  then calculate freezing damage.
     *
     *  Calculate the Player's hunger, thirst and condition damage
     *
     *  Calculate the damge based on a large amount of time passing
     *
     * @param player
     * @param weather
     * @param gameTime
     */
    public static void damagePlayerLarge(Player player, Weather weather, GameTime gameTime) {

        weather.calculateTemp(gameTime);
        Log.i("Jacob", "displaytext=" + player.getDisplayText());
        if (!player.isPlayerInside(RUNNING_GAME_BOARD)) {
            calcTempDamageLarge(player, weather, gameTime);
        }
        if (player.getDisplayText() == Player.YOU_WAITED_ALERT){
            calcHungerDamageWait(player);
        }
        else {
            calcHungerDamageLarge(player);
        }
        calcThirstDamageLarge(player);

        calcConditionDamageLarge(player);
    }
    /**
     *  Checks the current weather and determines the damage to the Player's temperature.
     *  The lower the temperature, the more damage done.
     *  Calculates based off a large amount of time passing.
     * @param player
     * @param weather
     * @param gameTime
     */
    private static void calcTempDamageLarge(Player player, Weather weather, GameTime gameTime) {

        double freezingDamage;
        double currentPlayerTemp = player.getTemperature();

        if (weather.calculateTemp(gameTime) < FREEZING_POINT) {

            freezingDamage = FREEZING_POINT - weather.calculateTemp(gameTime);

            player.setTemperature(currentPlayerTemp - freezingDamage);
        }
    }
    /**
     * Sets the Player's thirst to what it was, minus THIRST_DAMAGE_SMALL
     *
     * @param player
     */
    private static void calcThirstDamageLarge(Player player) {

        double currentPlayerThirst = player.getThirst();

        player.setThirst(currentPlayerThirst - THIRST_DAMAGE_LARGE);
    }
    /**
     * Sets the Player's hunger to what it originally was, minus HUNGER_DAMAGE_SMALL
     *
     * @param player
     */
    private static void calcHungerDamageLarge(Player player) {

        double currentPlayerHunger = player.getHunger();

        player.setHunger(currentPlayerHunger - HUNGER_DAMAGE_LARGE);
    }

    /**
     * If the Player's hunger, thirst or warmth reach zero, the Player's condition will begin to drop
     * @param player
     */
    private static void calcConditionDamageLarge(Player player) {

        if (player.getTemperature() == 0) {

            player.setCondition(player.getCondition() - CONDITION_DAMAGE_FREEZING_LARGE);
        }
        else if (player.getThirst() == 0) {

            player.setCondition(player.getCondition() - CONDITION_DAMAGE_THIRST_LARGE);
        }
        else if (player.getHunger() == 0) {

            player.setCondition(player.getCondition() - CONDITION_DAMAGE_HUNGER_LARGE);
        }
    }

    /**
     * Sets the Player's hunger to what it originally was, minus HUNGER_DAMAGE_SMALL
     *
     * @param player
     */
    private static void calcHungerDamageWait(Player player) {

        double currentPlayerHunger = player.getHunger();

        player.setHunger(currentPlayerHunger - HUNGER_DAMAGE_WAIT);
    }
}
